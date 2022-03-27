
package com.company;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
class Node
{
    String Lname;
    String mobileno;
    String email;
    String date;
    String flightbooked;
    Node next=null;
    String flightName;
    double TicketPrice;
    String departure;
    String Arivial;
    String Fname;

    Node(String Fname,String Lname,String mobileno,String email,String date,String flightbooked )
    {
        this.Fname=Fname;
        this.Lname=Lname;
        this.mobileno=mobileno;
        this.email=email;
        this.date=date;
        this.flightbooked=flightbooked;
    }

    Node(String f, String d, String A)
    {
        flightName=f;
        departure=d;
        Arivial=A;

    }
    public String getFname()
    {
        return Fname;
    }
    public void setFname(String fname)
    {
        Fname = fname;
    }
    public String getLname()
    {
        return Lname;
    }
    public void setLname(String lname)
    {
        Lname = lname;
    }
    public String getMobileno()
    {
        return mobileno;
    }
    public void setMobileno(String mobileno)
    {
        this.mobileno = mobileno;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getDate()
    {
        return date;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public String getFlightbooked()
    {
        return flightbooked;
    }
    public void setFlightbooked(String flightbooked)
    {
        this.flightbooked = flightbooked;
    }
    public Node getNext()
    {
        return next;
    }
    public void setNext(Node next)
    {
        this.next = next;
    }
    public String getFlightName()
    {
        return flightName;
    }
    public void setFlightName(String flightName)
    {
        this.flightName = flightName;
    }
    public double getTicketPrice()
    {
        return TicketPrice;

    }
    public void setTicketPrice(double ticketPrice)
    {
        TicketPrice = ticketPrice;
    }
    public String getDeparture()
    {
        return departure;
    }
    public void setDeparture(String departure)
    {
        this.departure = departure;
    }
    public String getArivial()
    {
        return Arivial;
    }
    public void setArivial(String arivial)
    {
        Arivial = arivial;
    }
    @Override
    public String toString()
    {
        return "Node{" +
                "Fname='" + Fname + '\'' +
                ", Lname='" + Lname + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                ", flightbooked='" + flightbooked + '\'' +
                ", next=" + next +
                ", flightName='" + flightName + '\'' +
                ", TicketPrice=" + TicketPrice +
                ", departure='" + departure + '\'' +
                ", Arivial='" + Arivial + '\'' +
                '}';
    }
}
class booking
{
    Scanner input=new Scanner(System.in);
    Node head;
    void showCustomerInfo()throws IOException
    {
        File f=new File("Data.txt");      //FILE IS OPENED AND READ BY THE CUSTOMER ON REQUEST
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        String s=null;
        while((s=br.readLine())!=null)
        {
            System.out.println(s);

        }
        fr.close();
    }


    void Takedata()throws IOException
    {

        System.out.println("Enter your first name");
        String Fname=input.next();
        System.out.println("Enter your last name");
        String Lname=input.next();
        System.out.println("Enter your Mobile number");
        String mobileno=input.next();
        System.out.println("Enter email");
        String email=input.next();
        System.out.println("Enter Today's Date");
        String date=input.next();
        System.out.println("Enter Flight you want to book");
        String flightbooked=input.next();
        BookTicket(Fname,Lname,mobileno,email,date,flightbooked);

        File f =new File("data.txt"); //HERE FILE IS CREATED, CALLED DATA, HERE THE CUSTOMER WILL PUT HIS/ HER INFORMATION LIKE
        FileWriter ad=new FileWriter(f,true); //NAME, LAST NAME ,CONTACT DETAILS, FLIGHT DETAIL ETC.
        String sp=" ";//All of this infomation is stored in the file .
        String nextline;
        ad.append(Fname);
        ad.append(sp);
        ad.append(Lname);
        ad.append(sp);
        ad.append(mobileno);
        ad.append(sp);
        ad.append(email);
        ad.append(sp);
        ad.append(date);
        ad.append(sp);
        ad.append(flightbooked);
        ad.flush();
        ad.close();

    }
    void Showflightdata() throws IOException
    {
        File f=new File("flightinfo.txt");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        String s1=null;
        while((s1=br.readLine())!=null)
        {
            System.out.println(s1);

        }
        fr.close();
    }


    void BookTicket(String Fname,String Lname,String mobileno,String email,String date,String flightbooked)
    {

        Node newNode=new Node( Fname, Lname, mobileno, email,date, flightbooked);
        if(head==null)
        {
            head=newNode;
        }
        else
            {
            Node currNode=head;
            while(currNode.next!=null)
            {
                currNode=currNode.next;
            }
            currNode.next=newNode;

        }

    }
    void CancelTicket(String key)
    {
        if(head==null){
            System.out.println("No flights to cancel");

        }
        if(head.Fname.equals(key))
        {
            head=head.next;
        }
        else
            {
            Node currNode=head;
            boolean flag=false;
            Node prev=currNode;
            while(currNode.next!=null)
            {
                if(currNode.Fname.equals(key))
                {
                    flag=true;
                }
                prev=currNode;
                currNode=currNode.next;

            }
            if(flag==true)
            {
                prev.next=currNode.next;
            }
            else
            {
                System.out.println("Ticket not found");
            }

        }

    }
    void Display()
    {
        Node  currNode=head;
        while(currNode!=null)
        {
            System.out.println(" Name:"+currNode.Fname+"\t\t\t\t\t\t\t\t|"+"\n Last name: "+currNode.Lname+"\t\t\t\t\t\t\t|\n Mobile number:"+currNode.mobileno+"\n E-mail:"+currNode.email+"\n Date:"+currNode.date+"\n flightbooked:"+currNode.flightbooked);
            currNode=currNode.next;
        }

    }
    void CheckFlightInformation(String key)
    {
        Node currNode=head;
        boolean flag=false;

        while(currNode!=null)
        {
            if(currNode.Fname.equals(key))
            {
                flag=true;
                break;
            }
            currNode=currNode.next;
        }
        if(flag==true)
        {
            System.out.println("Your Flight is booked, here in your information");
            System.out.println(" Name:"+currNode.Fname+"\t\t\t\t\t\t\t\t|"+"\n Last name: "+currNode.Lname+"\t\t\t\t\t\t\t|\n Mobile number:"+currNode.mobileno+"\n E-mail:"+currNode.email+"\n Date:"+currNode.date+"\n flightbooked:"+currNode.flightbooked);

        }
    }
}
 class Main
 {


    public static void main(String[] args)throws IOException
    {
        Scanner input=new Scanner(System.in);
        booking s=new  booking();
        int i=1;
        while(i!=0)
        {

            System.out.println("=========================================================================");
            System.out.println("|                                                                       | ");
            System.out.println("|                 ===================================                   |");
            System.out.println("|                  FLIGHT RESERVATION PROGRAM                           |");
            System.out.println("|                 ===================================                   |");
            System.out.println("|                  Please choose what you want to do                    |");
            System.out.println("|                      ====MENU====                                     |");
            System.out.println("|                  1-View flight Information                            |");
            System.out.println("|                  2-Book Flight                                        |");
            System.out.println("|                  3-Cancel flight                                      |");
            System.out.println("|                  4-Check flight information                           |");
            System.out.println("=========================================================================");
            System.out.println("Enter what you want to do ");
            int want=input.nextInt();
            if(want==1)
            {
                s.Showflightdata();
            }
            else if(want==2)
            {
                s.Takedata();
            }
            else if(want==3)
            {
                System.out.println("Enter your Name");
                String key;
                key=input.next();
                s.CancelTicket(key);
            }
            else if(want==4)
            {
                String key;
                System.out.println("Enter your name");
                key=input.next();
                s.CheckFlightInformation(key);
            }
            else
                {
                System.out.println("Please enter valid details.");
                }
            System.out.println("Would you like to exist Program?(0 to Exist, 1 to contiune)" );
            i=input.nextInt();
        }


    }
}
