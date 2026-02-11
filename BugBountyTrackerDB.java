import java.sql.*;
import java.util.*;

public class BugBountyTrackerDB {

    static final String url="jdbc:mysql://localhost:3306/bugtracker";
    static final String user="root";
    static final String password="navya07";   
    static Scanner sc=new Scanner(System.in);

    static void addBug(){
        try(Connection con=DriverManager.getConnection(url,user,password)){

            System.out.print("Enter Bug ID: ");
            int id=sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Title: ");
            String title=sc.nextLine();

            System.out.print("Enter Severity: ");
            String severity=sc.nextLine();

            System.out.print("Enter Reward: ");
            double reward=sc.nextDouble();
            sc.nextLine();

            String q="INSERT INTO bugs VALUES(?,?,?,?,?)";

            PreparedStatement ps=con.prepareStatement(q);
            ps.setInt(1,id);
            ps.setString(2,title);
            ps.setString(3,severity);
            ps.setString(4,"Open");
            ps.setDouble(5,reward);

            ps.executeUpdate();

            System.out.println("✅ Bug Added!");

        }catch(Exception e){
            System.out.println("❌ Error: "+e.getMessage());
        }
    }

    static void viewBugs(){
        try(Connection con=DriverManager.getConnection(url,user,password)){

            String q="SELECT * FROM bugs";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(q);

            boolean found=false;

            while(rs.next()){
                found=true;
                System.out.println("----------------------------");
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("Title: "+rs.getString("title"));
                System.out.println("Severity: "+rs.getString("severity"));
                System.out.println("Status: "+rs.getString("status"));
                System.out.println("Reward: $"+rs.getDouble("reward"));
            }

            if(!found)System.out.println("No bugs found.");

        }catch(Exception e){
            System.out.println("❌ Error: "+e.getMessage());
        }
    }

    static void updateBug(){
        try(Connection con=DriverManager.getConnection(url,user,password)){

            System.out.print("Enter Bug ID: ");
            int id=sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Status: ");
            String status=sc.nextLine();

            String q="UPDATE bugs SET status=? WHERE id=?";

            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,status);
            ps.setInt(2,id);

            int rows=ps.executeUpdate();

            if(rows>0)System.out.println("✅ Status Updated!");
            else System.out.println("❌ Bug Not Found!");

        }catch(Exception e){
            System.out.println("❌ Error: "+e.getMessage());
        }
    }

    static void deleteBug(){
        try(Connection con=DriverManager.getConnection(url,user,password)){

            System.out.print("Enter Bug ID: ");
            int id=sc.nextInt();
            sc.nextLine();

            String q="DELETE FROM bugs WHERE id=?";

            PreparedStatement ps=con.prepareStatement(q);
            ps.setInt(1,id);

            int rows=ps.executeUpdate();

            if(rows>0)System.out.println("✅ Bug Deleted!");
            else System.out.println("❌ Bug Not Found!");

        }catch(Exception e){
            System.out.println("❌ Error: "+e.getMessage());
        }
    }

    public static void main(String[] args){

        while(true){
            System.out.println("\n=== Bug Bounty Tracker ===");
            System.out.println("1.Add Bug");
            System.out.println("2.View Bugs");
            System.out.println("3.Update Bug");
            System.out.println("4.Delete Bug");
            System.out.println("5.Exit");
            System.out.print("Choose: ");

            int ch=sc.nextInt();
            sc.nextLine();

            if(ch==1)addBug();
            else if(ch==2)viewBugs();
            else if(ch==3)updateBug();
            else if(ch==4)deleteBug();
            else if(ch==5)break;
            else System.out.println("Invalid Option!");
        }
    }
}
