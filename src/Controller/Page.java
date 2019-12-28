package Controller;


import java.util.Vector;


public class Page  {
	//extends controller, controller
  public String name;

  public String type;

  private int users_number;

    /**
   * 
   * @element-type Users
   */
  public Vector  follow , create;
    public Vector  myPosts;
    /**
   * 
   * @element-type Posts
   */
  public Vector  has;

  public void numberOfUsers() {
  }

}