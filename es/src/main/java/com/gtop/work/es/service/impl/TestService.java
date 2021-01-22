package com.gtop.work.es.service.impl;

import com.gtop.work.es.entity.MonitorDevice;
import com.gtop.work.es.service.ITestService;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Iterator;

/**
 * @author hongzw@citycloud.com.cn
 */
@Service
public class TestService implements ITestService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public String stringQuery() {
        Query query = new StringQuery("{\n" +
                "        \"bool\": {\n" +
                "            \"must\": {\n" +
                "                \"match\": {\n" +
                "                    \"address\": \"黄村地铁\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"filter\": {\n" +
                "                \"geo_distance\": {\n" +
                "                    \"distance\": \"20m\",\n" +
                "                    \"location\": {\n" +
                "                        \"lat\": 39.400083123,\n" +
                "                        \"lon\": 16.430891123\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }");
        IndexCoordinates indexCoordinates = IndexCoordinates.of("one_page");
        SearchHits<MonitorDevice> search = elasticsearchOperations.search(query, MonitorDevice.class, indexCoordinates);
        Iterator<SearchHit<MonitorDevice>> iterator = search.iterator();
        while (iterator.hasNext()) {
            SearchHit<MonitorDevice> next = iterator.next();
            System.out.println(next);
        }
        return "ok";
    }

    @Override
    public String nativeSearchQuery() {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .must(new MatchQueryBuilder("address", "黄村地铁站"))
                .filter(new GeoDistanceQueryBuilder("location").distance("20m").point(39.400083123, 16.430891123));

        GeoDistanceSortBuilder location = SortBuilders.geoDistanceSort("location", 39.400083123, 16.430891123).order(SortOrder.ASC);

        Pageable pageable = PageRequest.of(0, 1);

        Query query = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withSort(location)
                .withPageable(pageable)
                .build();
        IndexCoordinates indexCoordinates = IndexCoordinates.of("one_page");
        SearchHits<MonitorDevice> search = elasticsearchOperations.search(query, MonitorDevice.class, indexCoordinates);

        Iterator<SearchHit<MonitorDevice>> iterator = search.iterator();
        while (iterator.hasNext()) {
            SearchHit<MonitorDevice> next = iterator.next();
            int distance = new BigDecimal(next.getSortValues().get(0).toString()).intValue();
            MonitorDevice content = next.getContent();
            GeoPoint point = content.getLocation();
            System.out.println("distance=" + distance + ",point=" + point);
        }
        return "OK";
    }

    @Override
    public String nativeSearchQuery2() {

        GeoPoint geoPoint = new GeoPoint(39.400083123, 16.430891123);

        // 查询条件，距离中心点位10m范围内
        GeoDistanceQueryBuilder geoDistanceQueryBuilder = new GeoDistanceQueryBuilder("location")
                .point(geoPoint)
                .distance("20m");

        // 创建嵌套的bool查询条件，满足条件monitorCode='123457890' 或 address like '%潮汕牛肉火锅店%'
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.should(new TermQueryBuilder("monitorCode", "123457890"));
        boolQueryBuilder.should().add(new BoolQueryBuilder().should(new MatchPhraseQueryBuilder("address", "潮汕牛肉火锅店")));
        boolQueryBuilder.minimumShouldMatch(1);

        boolQueryBuilder.filter(geoDistanceQueryBuilder);

        // 排序，并按距离中心点位大小升序排列
        GeoDistanceSortBuilder sortBuilder = SortBuilders.geoDistanceSort("location", geoPoint).order(SortOrder.ASC);

        // 分页
        Pageable pageable = PageRequest.of(0, 1);

        Query query = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withSort(sortBuilder)
                .withPageable(pageable)
                .build();

        IndexCoordinates indexCoordinates = IndexCoordinates.of("one_page");
        SearchHits<MonitorDevice> search = elasticsearchOperations.search(query, MonitorDevice.class, indexCoordinates);

        Iterator<SearchHit<MonitorDevice>> iterator = search.iterator();
        while (iterator.hasNext()) {
            SearchHit<MonitorDevice> next = iterator.next();
            int distance = new BigDecimal(next.getSortValues().get(0).toString()).intValue();
            MonitorDevice content = next.getContent();
            GeoPoint point = content.getLocation();
            System.out.println("distance=" + distance + ",point=" + point);
        }
        return "OK";
    }


}
