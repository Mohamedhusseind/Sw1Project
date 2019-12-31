package Model;


public class UserManagment {
	RegistrationDB rdb;
	User u;
	public UserManagment()
	{
		rdb=new RegistrationDB();		
	}
	public void SetUser(User t)
    {
        u=new User();
        u.SetUserName(t.GetUserName());
        u.SetPassword(t.GetPassord());
        u.SetPhone(t.GetPhone());
        u.SetAddress(t.GetAddres());
    }
    public User isExist(User t)
    { 
    	User u=rdb.SearchUserRec(t);
        if(u==null)
            return null;
        else
        {
            if(rdb.check(u,t.GetPassord()))
            {
                return u;
            }
            return null;
        }
    }
    
    public User upgradeToPremium(User u)
    {
    	User userCopy=new User();
    	userCopy.SetUser(u);
    	u=new PremiumUser(userCopy);
    	return u;
    }
	
	 public boolean isValidUser(User t)
	    {

	        if(t.GetUserName().length()==0)
	          {System.out.println("Name "+ " "+t.GetUserName() );return false;}
	        if(t.GetPassord()=="")
	        	{System.out.println("pass "+ " "+t.GetPassord() );return false;	}
	        if(rdb.SearchUserRec(t)!=null)
	        	return false;
	        if(t.GetPhone().length()==0)
	        	return false;
	        saveUser(t);
	        return true;
	    }
	 public void saveUser(User t) {

	        rdb.AddUserRecord(t);
	  } 

  public void savePageInfo() {
  }

  public void saveGroupInfo() {
  }

  public void saveUserInfo() {
  }

  public void saveMessage() {
  }

  public void savePost() {
  }

  public void deleteGroup() {
  }

  public void deletePage() {
  }

  public void AddFriend() {
  }

  public void DeleteFriend() {
  }

}