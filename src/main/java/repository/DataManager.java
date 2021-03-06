package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import model.*;

public class DataManager {
	private final static String fileClient = "client.txt";
    private final static String fileIssue = "issue.txt";
    public ArrayList<Client> Clients;
    public ArrayList<Issue> Issues;
    
    public DataManager(){
        Clients = new ArrayList<>();
        Issues = new ArrayList<>();
        
        LoadClient();
        LoadIssues();
//        for(Issue i: Issues)
//        {
//            System.out.println(i.Client.toString() + '\n');
//        }
    }
    
    private void LoadClient(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileClient));
            String line;
            while((line = br.readLine()) != null){
                List<String> client_list = Arrays.asList(line.split(","));
                String name = client_list.get(0);
                String address = client_list.get(1);
                String id = client_list.get(2);
                Clients.add(new Client(name, address, id));
            }
            br.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    private void LoadIssues(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileIssue)); 
            String line;
            Boolean b = true;
            String name = "";
            String address = "";
            String id="";
            String sYear;
            String sMonth;
            String sToPay;
            String sPaid;
            
            while((line = br.readLine()) != null){
                if(b){
//                    int i1 = line.indexOf(",");
//                    name = line.substring(0, i1);
//                    address = line.substring(i1+2);
//                    id= line.substring(i1+3);
                    List<String> client_list = Arrays.asList(line.split(","));
                    name = client_list.get(0);
                    address = client_list.get(1);
                    id = client_list.get(2);
                    b = false;
                }else{
                    int i = line.indexOf(",");
                    sYear = line.substring(0, i);
                    line = line.substring(i+2);
                    i = line.indexOf(",");
                    sMonth = line.substring(0, i);
                    line = line.substring(i+2);
                    i = line.indexOf(",");
                    sToPay = line.substring(0, i);
                    sPaid = line.substring(i+2);
                    
                    Issues.add(new Issue(
                            new Client(name, address, id), 
                            Integer.parseInt(sYear), Integer.parseInt(sMonth), Float.parseFloat(sToPay), Float.parseFloat(sPaid)));
                    b = true;
                }
            }
            br.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    public void SaveChanges(){
        try{
            File fClient = new File(fileClient);
            File fIssue = new File(fileIssue);
            FileWriter pwClient = new FileWriter(fClient.getAbsolutePath());
            FileWriter pwIssue = new FileWriter(fIssue.getAbsolutePath());
            String s;
            try (BufferedWriter bwc = new BufferedWriter(pwClient)) {
                s = "";
                for (Client c : Clients) {
                    s += c.toString() + "\r\n";
                }
                bwc.write(s);
            }
            try (BufferedWriter bwi = new BufferedWriter(pwIssue)) {
                s = "";
                for (Issue iss : Issues) {
                    s += iss.toString() + "\r\n";
                }
                bwi.write(s);
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<Issue> getInvoicesList()
	{
		return Issues;	
	}
    public ArrayList<Client> getClientsList()
	{
		return Clients;	
	}
}
