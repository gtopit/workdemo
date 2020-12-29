package com.gtop.work;

import lombok.Data;

/**
 * 推送事件请求
 * @author hongzw@citycloud.com.cn
 */
@Data
public class PushingEvent {

    private Integer vsId;

    private String position;

    private String licenceNo;

    private String seeTime;

    private String happenedTime;

    private Integer distance;

    private String eventType;

    private String description;

    /**
     * 返回值为true则不再推送事件
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof PushingEvent) {
            PushingEvent event = (PushingEvent) object;

            if ((event.getDistance() + "").equals(this.getDistance() + "")
                    && (event.getHappenedTime() + "").equals(this.getHappenedTime())
                    && (event.getLicenceNo() + "").equals(this.getLicenceNo())
                    && (event.getPosition() + "").equals(this.getPosition())
                    && (event.getEventType() + "").equals(this.getEventType())
                    && (event.getSeeTime() + "").equals(this.getSeeTime())
            ) {
                return true;
            }
        }
        return false;
    }

}
