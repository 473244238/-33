package li.西二task3;
import li.西二task3.sqltask1;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
public class sqltask11 {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("请写下你想要查询学生的id");
        int id=s.nextInt();
        sqlenquary(id);//用于查询学生的方法
        System.out.println("请写下你想要删除学生的id");
        int id2=s.nextInt();
        sqldelete(id2);//用于你想要删除学生的方法
       sqlinsert();//用于你想要添加新来学生的方法
        sqlupdate();//用于更新学生信息
       gradeupdate();//用于更新班级信息



    }
    public static void sqlenquary(int id2){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{
            conn= sqltask1.getConnection();

            String sql="select * from collegestudent where studentid=?";
            st=conn.prepareStatement(sql);

            st.setInt(1,id2);

            rs=st.executeQuery();

            if(rs.next()){
                System.out.println(rs.getObject("studentid"));
                System.out.println(rs.getObject("studentnum"));
                System.out.println(rs.getObject("name"));
                System.out.println(rs.getObject("sex"));
                System.out.println(rs.getObject("enrollment time"));
                System.out.println(rs.getObject("address"));
            }

            //执行




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
          sqltask1.release(conn,st,rs);
        }
    }
    public static void sqldelete(int id2){
        Connection conn=null;
        PreparedStatement st=null;
        try{
            conn= sqltask1.getConnection();
            //区别
            //使用？占位符代替参数
            String sql="delete from collegestudent where studentid=?";
            st=conn.prepareStatement(sql);//预编译SQL，先写SQL，然后不执行
            //手动给参数赋值
            st.setInt(1,id2);





            //执行
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("删除成功");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            sqltask1.release(conn,st,null);
        }
    }
    public static void sqlinsert(){
        Scanner s2=new Scanner(System.in);
        Scanner s3=new Scanner(System.in);
        Connection conn=null;
        PreparedStatement st=null;
        try{
            conn=sqltask1.getConnection();
            //区别
            //使用？占位符代替参数
            String sql="insert into collegestudent(studentid,`studentnum`,`name`,`sex`,`enrollment time`,`address`)values(?,?,?,?,?,?)";
            st=conn.prepareStatement(sql);//预编译SQL，先写SQL，然后不执行
            //手动给参数赋值
            System.out.println("请输入你要插入的学生的学号");
            st.setString(2,s2.nextLine());
            System.out.println("请输入你要插入的学生的id");
            st.setInt(1,s2.nextInt());
            System.out.println("请输入你要插入的学生的名字");
            st.setString(3,s2.next());


            System.out.println("请输入你要插入的学生的性别");
            st.setString(4,s2.next());
            st.setDate(5,new java.sql.Date(new Date().getTime()));//这个函数以获得现在的时间为主
            System.out.println("请输入你的地址");
            st.setString(6,s2.next());
            //执行
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("插入成功");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            sqltask1.release(conn,st,null);
        }
    }
    public static void sqlupdate(){
        Connection conn=null;
        PreparedStatement st=null;
        Scanner s4=new Scanner(System.in);
        try{
            conn= sqltask1.getConnection();

            String sql="update collegestudent set `studentnum`=? where studentid=?";//这里我就以学号和地址为例
            String sql2="update collegestudent set `address`=? where studentid=?";
            st=conn.prepareStatement(sql);

            System.out.println("你想要改的学号");
            st.setString(1,s4.nextLine());
            System.out.println("条件：id");
            st.setInt(2,s4.nextInt());
            int i=st.executeUpdate();
            st=conn.prepareStatement(sql2);

            System.out.println("你想要改的地址");
            st.setString(1,s4.next());
            System.out.println("条件：id");
            st.setInt(2,s4.nextInt());
           int i2=st.executeUpdate();

            //执行

            if(i>0&&i2>0){
                System.out.println("修改成功");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            sqltask1.release(conn,st,null);
        }
    }
    public static void gradeupdate(){
        Scanner s5=new Scanner(System.in);
        Connection conn=null;
        PreparedStatement st=null;
        try{
            conn= sqltask1.getConnection();

            String sql="update collegegrade set `classnum`=? where `name`=?";

            st=conn.prepareStatement(sql);
            System.out.println("修改学生在班级的座号");
            st.setString(1,s5.next());
            System.out.println("条件：name");
            st.setString(2,s5.next());
            int i=st.executeUpdate();

            if(i>0){
                System.out.println("修改成功");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            sqltask1.release(conn,st,null);
        }
    }

    }

