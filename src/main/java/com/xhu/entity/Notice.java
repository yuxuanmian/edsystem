package com.xhu.entity;


import java.sql.Timestamp;

public class Notice {

  private Integer id;
  private String title;
  private String content;
  private String recept_role;
  private Timestamp sendtime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getRecept_role() {
    return recept_role;
  }

  public void setRecept_role(String recept_role) {
    this.recept_role = recept_role;
  }

  public Timestamp getSendtime() {
    return sendtime;
  }

  public void setSendtime(Timestamp sendtime) {
    this.sendtime = sendtime;
  }

  @Override
  public String toString() {
    return "Notice{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", recept_role='" + recept_role + '\'' +
            ", sendtime=" + sendtime +
            '}';
  }
}
