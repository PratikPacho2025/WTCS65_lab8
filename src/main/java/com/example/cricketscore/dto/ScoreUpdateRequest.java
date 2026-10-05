package com.example.cricketscore.dto;

public class ScoreUpdateRequest {
    private Long teamId, batsmanId, bowlerId;
    private int runs;
    private boolean wicket;
    private String eventType;
    public Long getTeamId(){return teamId;} public void setTeamId(Long v){teamId=v;}
    public Long getBatsmanId(){return batsmanId;} public void setBatsmanId(Long v){batsmanId=v;}
    public Long getBowlerId(){return bowlerId;} public void setBowlerId(Long v){bowlerId=v;}
    public int getRuns(){return runs;} public void setRuns(int v){runs=v;}
    public boolean isWicket(){return wicket;} public void setWicket(boolean v){wicket=v;}
    public String getEventType(){return eventType;} public void setEventType(String v){eventType=v;}
}
