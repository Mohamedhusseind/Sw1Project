package Model;

import java.io.File;
import java.util.*;

public class RegistrationDB {
    static Formatter out;
    static Scanner sc;
    static Vector <User>MyUsersDB=new Vector<>();
    RegistrationDB()
    {

        try {sc = new Scanner(new File("RegDB.txt"));}
        catch (Exception e) {}
        int sz=Integer.parseInt(sc.nextLine());
        for(int i=0;i<sz;i++)
        {
            User u=new User();
            u.SetUserName(sc.nextLine());
            u.SetPassword(sc.nextLine());
            u.SetPhone(sc.nextLine());
            u.SetAddress(sc.nextLine());
            MyUsersDB.add(u);
        }
    }
    public boolean AddUserRecord(User u) {

        User indx=SearchUserRec(u);
        if(indx==null)	//Exception handels here
        {MyUsersDB.add(u);UpdateUserDB();return true;}
        else
            return false;
    }
    public User SearchUserRec(User u) {
        for(int i=0;i<MyUsersDB.size();i++)
        {
            if(u.GetUserName().equals(MyUsersDB.elementAt(i).GetUserName()))
            {return MyUsersDB.get(i);}
        }return null;
    }
    boolean check(User u,String pass)
    {
    	int ind=MyUsersDB.indexOf(u);
        if(MyUsersDB.elementAt(ind).GetPassord().equals(pass))return true;
        return false;
    }

    public boolean DeleteUserRecord(User U) {
        User u=SearchUserRec(U);
        if(u==null)	//Exception handels here
        {
            return false;
        }
        else
        {
        	MyUsersDB.remove(MyUsersDB.lastIndexOf(u));
            UpdateUserDB();
            return true;
        }
    }
    static void writeOnFile(String code) {
        out.format("%s", code);
        out.format("%n");
        out.flush();
    }
    public void UpdateUserDB() {
        try {out = new Formatter("RegDB.txt");}
        catch (Exception e) {}
        String sz=""+MyUsersDB.size();writeOnFile(sz);
        for(int i=0;i<MyUsersDB.size();i++)
        {
            writeOnFile(MyUsersDB.elementAt(i).GetUserName());
            writeOnFile(MyUsersDB.elementAt(i).GetPassord());
            writeOnFile(MyUsersDB.elementAt(i).GetPhone());
            writeOnFile(MyUsersDB.elementAt(i).GetAddres());
        }

    }
}