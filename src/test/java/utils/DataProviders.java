package utils;

import dto.ContactDTO;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Diana", "Lukovsky", "545737504", "feling@protomail.com", "Tel Aviv", "friend"});
        list.add(new Object[]{"Diana1", "Lukovsky", "545737603", "feling@protomail.com", "Tel Aviv", "friend"});
        list.add(new Object[]{"Diana2", "Lukovsky", "545737602", "feling@protomail.com", "Tel Aviv", "friend"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactCSVFile() {
        List<Object[]> list = new ArrayList<>();
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File("contacts.csv")));
           line = reader.readLine();

           while(line != null) {
               String [] split = line.split(",");
               list.add(new Object[]{new ContactDTO().setName(split[0]).setLastName(split[1])
                   .setPhone(split[2]).setEmail(split[3]).setAddress(split[4])
                       .setDescription(split[5]) });
               line = reader.readLine();
           }

           reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }

}
