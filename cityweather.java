package li.西二task3;//处理天气信息一些方法

import li.lesson2.util.util.jbdcutils;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
public class cityweather {
    public static void main(String args[]){
        //cityfind();//用于查找城市信息
       //weatherfind();//用于查找天气信息
      //updateweather();//用于更新天气信息

    }
    public static void cityfind(){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        Scanner s1=new Scanner(System.in);
        try{
            conn= sqltask1.getConnection();

            String sql="select * from city where name=?";
            st=conn.prepareStatement(sql);
            System.out.println("请输入你想要查找城市的名字");
            st.setString(1,s1.nextLine());

            rs=st.executeQuery();

            if(rs.next()){
                System.out.println(rs.getObject("id"));
                System.out.println(rs.getObject("name"));
                System.out.println(rs.getObject("lat"));
                System.out.println(rs.getObject("lon"));
                System.out.println(rs.getObject("country"));

            }


            //执行




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            sqltask1.release(conn,st,rs);
        }
    }
    public static void weatherfind(){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        Scanner s2=new Scanner(System.in);
        try{
            conn= sqltask1.getConnection();
            System.out.println("请输入你要查找的城市");
            String city=s2.nextLine();
            String sql="select * from weather1 where name=?";
            st=conn.prepareStatement(sql);
            st.setString(1,city);
            rs=st.executeQuery();
            if(rs.next()){
                System.out.println(rs.getObject("name"));
                System.out.println(rs.getObject("fxdate"));
                System.out.println(rs.getObject("tempmax"));
                System.out.println(rs.getObject("tempmin"));
                System.out.println(rs.getObject("textday"));
            }
            System.out.println("===========================");
            String sql2="select * from weather2 where name=?";
            st=conn.prepareStatement(sql2);
            st.setString(1,city);
            rs=st.executeQuery();
            if(rs.next()){
                System.out.println(rs.getObject("name"));
                System.out.println(rs.getObject("fxdate"));
                System.out.println(rs.getObject("tempmax"));
                System.out.println(rs.getObject("tempmin"));
                System.out.println(rs.getObject("textday"));
            }
            System.out.println("===========================");
            String sql3="select * from weather3 where name=?";
            st=conn.prepareStatement(sql3);
            st.setString(1,city);
            rs=st.executeQuery();
            if(rs.next()){
                System.out.println(rs.getObject("name"));
                System.out.println(rs.getObject("fxdate"));
                System.out.println(rs.getObject("tempmax"));
                System.out.println(rs.getObject("tempmin"));
                System.out.println(rs.getObject("textday"));
            }
            System.out.println("===========================");
            //执行
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            sqltask1.release(conn,st,rs);
        }
    }
    public static void updateweather(){
        Scanner s3=new Scanner(System.in);
        Connection conn=null;
        PreparedStatement st=null;
        try{
            conn= jbdcutils.getConnection();
            //这里你可以进行手动修改，不用控制台
            String sql="UPDATE weather1 SET `fxdate`=?,`tempmax`=?,`tempmin`=?,`textday`=? where name=?";
            st=conn.prepareStatement(sql);
            int i=st.executeUpdate();
            String sql2="UPDATE weather2 SET `fxdate`=?,`tempmax`=?,`tempmin`=?,`textday`=? where name=?";
            st=conn.prepareStatement(sql2);
            int i2=st.executeUpdate();
            String sql3="UPDATE weather3 SET `fxdate`=?,`tempmax`=?,`tempmin`=?,`textday`=? where name=?";
            st=conn.prepareStatement(sql3);
            int i3=st.executeUpdate();

            if(i>0&i2>0&i3>0){
                System.out.println("修改成功");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jbdcutils.release(conn,st,null);
        }
    }
}


