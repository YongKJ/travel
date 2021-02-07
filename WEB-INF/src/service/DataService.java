
import java.io.*;
import java.util.*;

public class DataService {
    
    public String filePath;
    public Map<String, Attention> attentionsMap;
    public Map<String, Attractions> attractionsMap;
    public Map<String, Busertable> busertablesMap;
    public Map<String, City> citysMap;
    public Map<String, Label> labelsMap;
    public Map<String, Membership> membershipsMap;
    public Map<String, Order> ordersMap;
    public Map<String, Orderdetails> orderdetailsMap;
    public Map<String, Promary> promarysMap;
    public Map<String, Strategy> strategysMap;
    public Map<String, Userevaluation> userevaluationsMap;
    
    
    public DataService(String realPath) {
        filePath = realPath + "WEB-INF/src/data/";
        attentionsMap = new HashMap<>();
        attractionsMap = new HashMap<>();
        busertablesMap = new HashMap<>();
        citysMap = new HashMap<>();
        labelsMap = new HashMap<>();
        membershipsMap = new HashMap<>();
        ordersMap = new HashMap<>();
        orderdetailsMap = new HashMap<>();
        promarysMap = new HashMap<>();
        strategysMap = new HashMap<>();
        userevaluationsMap = new HashMap<>();
    }
    
    public void writeToLog(String str) throws Exception {
        String fileName = filePath + "../Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
    
    public void writeToLog(int str) throws Exception {
        String fileName = filePath + "../Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
    
    public List<String> getLocalTxtFileData(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath + fileName)), "UTF-8"));
        List<String> results = new ArrayList<>();
        String lineTxt = null;
        while ((lineTxt = br.readLine()) != null) {
            results.add(lineTxt);
        }
        br.close();
        return results;
    }
    
    public void getAttentionsMap() throws Exception {
        List<String> results = getLocalTxtFileData("Attention.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            Attention attention = new Attention();
            attention.setaId(Integer.parseInt(result[1]));
            attention.setaData(result[2]);
            attention.setaAttractionsId(Integer.parseInt(result[3]));
            attention.setaBUserTableId(Integer.parseInt(result[4]));
            attentionsMap.put(result[0], attention);
        }
    }
    
    public void getAttractionsMap() throws Exception {
        List<String> results = getLocalTxtFileData("Attractions.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            Attractions attractions = new Attractions();
            attractions.setaId(Integer.parseInt(result[1]));
            attractions.setaName(result[2]);
            attractions.setaPicture(result[3]);
            attractions.setaBstract(result[4]);
            attractions.setaUnitPrice(Double.parseDouble(result[5]));
            attractions.setaCostContent(result[6]);
            attractions.setaScore(result[7]);
            attractions.setaLabelId(Integer.parseInt(result[8]));
            attractions.setaCityId(Integer.parseInt(result[9]));
            attractionsMap.put(result[0], attractions);
        }
    }
    
    public void getBusertablesMap() throws Exception {
        List<String> results = getLocalTxtFileData("Busertable.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            Busertable busertable = new Busertable();
            busertable.setbId(Integer.parseInt(result[1]));
            busertable.setbNumber(result[2]);
            busertable.setbPWD(result[3]);
            busertable.setbName(result[4]);
            busertable.setbEmail(result[5]);
            busertable.setrName(result[6]);
            busertable.setbSex(result[7]);
            busertable.setBirthday(result[8]);
            busertable.setbPhone(result[9]);
            busertablesMap.put(result[0], busertable);
        }
    }
    
    public void getCitysMap() throws Exception {
        List<String> results = getLocalTxtFileData("City.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            City city = new City();
//             writeToLog(Integer.parseInt(result[1]));
            city.setCityId(Integer.parseInt(result[1]));
            city.setCityName(result[2]);
            city.setProId(Integer.parseInt(result[3]));
            citysMap.put(result[0], city);
        }
    }
    
    public void getLabelsMap() throws Exception {
        List<String> results = getLocalTxtFileData("Label.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            Label label = new Label();
            label.setlId(Integer.parseInt(result[1]));
            label.setlName(result[2]);
            labelsMap.put(result[0], label);
        }
    }
    
    public void getMembershipsMap() throws Exception {
        List<String> results = getLocalTxtFileData("Membership.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            Membership membership = new Membership();
            membership.setmId(Integer.parseInt(result[1]));
            membership.setmName(result[2]);
            membership.setmPrice(Double.parseDouble(result[3]));
            membership.setmAttractionsId(Integer.parseInt(result[4]));
            membershipsMap.put(result[0], membership);
        }
    }
    
    public void getOrdersMap() throws Exception {
        List<String> results = getLocalTxtFileData("Order.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            Order order = new Order();
            order.setoId(Integer.parseInt(result[1]));
            order.setoPrice(Double.parseDouble(result[2]));
            order.setoState(result[3]);
            order.setoData(result[4]);
            order.setoBUserTableId(Integer.parseInt(result[5]));
            ordersMap.put(result[0], order);
        }
    }
    
    public void getOrderdetailsMap() throws Exception {
        List<String> results = getLocalTxtFileData("Orderdetails.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            Orderdetails orderdetails = new Orderdetails();
            orderdetails.setNumber(Integer.parseInt(result[1]));
            orderdetails.setdAttractionsId(Integer.parseInt(result[2]));
            orderdetails.setdOrderId(Integer.parseInt(result[3]));
            orderdetailsMap.put(result[0], orderdetails);
        }
    }
    
    public void getPromarysMap() throws Exception {
        List<String> results = getLocalTxtFileData("Promary.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            Promary promary = new Promary();
            promary.setProId(Integer.parseInt(result[1]));
            promary.setProName(result[2]);
            promarysMap.put(result[0], promary);
        }
    }
    
    public void getStrategysMap() throws Exception {
        List<String> results = getLocalTxtFileData("Strategy.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            Strategy strategy = new Strategy();
            strategy.setsId(Integer.parseInt(result[1]));
            strategy.setsTitle(result[2]);
            strategy.setsText(result[3]);
            strategy.setsDataTime(result[4]);
            strategy.setsPlace(result[5]);
            strategy.setsReading(result[6]);
            strategy.setsBUserTableId(Integer.parseInt(result[7]));
            strategysMap.put(result[0], strategy);
        }
    }
    
    public void getUserevaluationsMap() throws Exception {
        List<String> results = getLocalTxtFileData("Userevaluation.txt");
        for(int i = 0; i < results.size(); i++) {
            String[] result = results.get(i).split(" ");
            Userevaluation userevaluation = new Userevaluation();
            userevaluation.setuId(Integer.parseInt(result[1]));
            userevaluation.setuEvaluationText(result[2]);
            userevaluation.setuPrcture(result[3]);
            userevaluation.setuData(result[4]);
            userevaluation.setuAttractionsId(Integer.parseInt(result[5]));
            userevaluation.setuBUserTableId(Integer.parseInt(result[6]));
            userevaluationsMap.put(result[0], userevaluation);
        }
    }
    
//     public void setPromarysMap() {
//         String fileName = "Promary.txt";
//         FileWriter writeFile = new FileWriter(filePath + fileName);
//         BufferedWriter writer = new BufferedWriter(writeFile);
//         for(Map.Entry<String, Promary> pr : promarysMap) {
//             Promary promary = pr.getValue();
//             writer(pr.getKey() + " ");
//             writer((promary.getProId() + 1) + " ");
//             writer(promary.getProName() + "\n");
//         }
//         writer.flush();
//         writeFile.close();
//     }
    
    public Attention getAttentionData(String tableOperation) throws Exception {
        getAttentionsMap();
        return attentionsMap.get(tableOperation);
    }
    
    public Attractions getAttractionsData(String tableOperation) throws Exception {
        getAttractionsMap();
        return attractionsMap.get(tableOperation);
    }
    
    public Busertable getBusertableData(String tableOperation) throws Exception {
//         writeToLog("111111");
        getBusertablesMap();
//         writeToLog("222222");
        return busertablesMap.get(tableOperation);
    }
    
    public City getCityData(String tableOperation) throws Exception {
        getCitysMap();
        return citysMap.get(tableOperation);
    }
    
    public Label getLabelData(String tableOperation) throws Exception {
        getLabelsMap();
        return labelsMap.get(tableOperation);
    }
    
    public Membership getMembershipData(String tableOperation) throws Exception {
        getMembershipsMap();
        return membershipsMap.get(tableOperation);
    }
    
    public Order getOrderData(String tableOperation) throws Exception {
        getOrdersMap();
        return ordersMap.get(tableOperation);
    }
    
    public Orderdetails getOrderdetailsData(String tableOperation) throws Exception {
        getOrderdetailsMap();
        return orderdetailsMap.get(tableOperation);
    }
    
    public Promary getPromaryData(String tableOperation) throws Exception {
        getPromarysMap();
//         if(tableOperation.equals("del")) {
//             setPromarysMap();
//         }
        return promarysMap.get(tableOperation);
    }
    
    public Strategy getStrategyData(String tableOperation) throws Exception {
        getStrategysMap();
        return strategysMap.get(tableOperation);
    }
    
    public Userevaluation getUserevaluationData(String tableOperation) throws Exception {
        getUserevaluationsMap();
        return userevaluationsMap.get(tableOperation);
    }
    
}