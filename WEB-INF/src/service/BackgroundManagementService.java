
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class BackgroundManagementService{
    
    public HttpServletRequest request;
    public HttpServletResponse response;
    public String tableName;
    public String tableOperation;
    public String account;
    public String password;
    public RequestDispatcher dispatcher;
    
    public BusertableService buService;
    public PromaryService prService;
    public CityService ciService;
    public LabelService laService;
    public AttractionsService arService;
    public MembershipService meService;
    public StrategyService stService;
    public AttentionService aeService;
    public UserevaluationService usService;
    public OrderdetailsService odService;
    public OrderService orService;
    
    public BackgroundManagementService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        tableName = null;
        tableOperation = null;
        account = null;
        password = null;
        
        buService = new BusertableService();
        prService = new PromaryService();
        ciService = new CityService();
        laService = new LabelService();
        arService = new AttractionsService();
        meService = new MembershipService();
        stService = new StrategyService();
        aeService = new AttentionService();
        usService = new UserevaluationService();
        odService = new OrderdetailsService();
        orService = new OrderService();
    }
    
    public void writeToLog(String str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
    
    public void writeToLog(int str) throws Exception {
        String fileName = "/usr/local/tomcat/apache-tomcat-9.0.19/webapps/travel/WEB-INF/src/Log.txt";
        FileWriter writeFile = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(writeFile);
		
		writer.write(str + "\n");
        
        writer.flush();
        writeFile.close();
    }
    
    public void judgeBusertable(String tableOperation) throws Exception {
        Busertable busertable = new Busertable();
        String id = request.getParameter("id");
        String bNumber = request.getParameter("bNumber");
        String bPWD = request.getParameter("bPWD");
        String bName = request.getParameter("bName");
        String bEmail = request.getParameter("bEmail");
        String rName = request.getParameter("rName");
        String bSex = request.getParameter("bSex");
        String birthday = request.getParameter("birthday");
        String bPhone = request.getParameter("bPhone");
        
        if(tableOperation == null) {
            dispatcher = request.getRequestDispatcher("/BusertableAddManagement.jsp");
            request.setAttribute("busertablesList", buService.getBusertable());
        }else if(tableOperation.equals("add")) {
            if(bNumber != null && bPWD != null && bName != null && bEmail != null && rName != null && bSex != null && birthday != null && bPhone != null) {
                String str[] = birthday.split("/");
                birthday = str[2] + "-" + str[0] + "-" + str[1];
                
                busertable.setbNumber(bNumber);
                busertable.setbPWD(bPWD);
                busertable.setbName(bName);
                busertable.setbEmail(bEmail);
                busertable.setrName(rName);
                busertable.setbSex(bSex);
                busertable.setBirthday(birthday);
                busertable.setbPhone(bPhone);
                buService.addBusertable(busertable);
            }
            dispatcher = request.getRequestDispatcher("/BusertableAddManagement.jsp");
            request.setAttribute("busertablesList", buService.getBusertable());
        }else if(tableOperation.equals("modOne")) {
            if(id != null) {
                dispatcher = request.getRequestDispatcher("/BusertableModManagementTwo.jsp");
                List<Busertable> busertablesList = buService.getBusertable();
                for(int i = 0; i < busertablesList.size(); i++) {
                    if(Integer.parseInt(id) == busertablesList.get(i).getbId()) {
//                         String str[] = busertablesList.get(i).getBirthday().split(" ");
//                         busertablesList.get(i).setBirthday(str[0]);
                        request.setAttribute("busertable", busertablesList.get(i));
                        break;
                    }
                }
            }else{
                dispatcher = request.getRequestDispatcher("/BusertableModManagementOne.jsp");
                request.setAttribute("busertablesList", buService.getBusertable());
            }
        }else if(tableOperation.equals("modTwo")) {
            if(id != null && bNumber != null && bPWD != null && bName != null && bEmail != null && rName != null && bSex != null && birthday != null && bPhone != null) {
                busertable.setbId(Integer.parseInt(id));
                busertable.setbNumber(bNumber);
                busertable.setbPWD(bPWD);
                busertable.setbName(bName);
                busertable.setbEmail(bEmail);
                busertable.setrName(rName);
                busertable.setbSex(bSex);
                busertable.setBirthday(birthday);
                busertable.setbPhone(bPhone);
                buService.modBusertable(busertable);
            }
            
            dispatcher = request.getRequestDispatcher("/BusertableModManagementOne.jsp");
            request.setAttribute("busertablesList", buService.getBusertable());
        }else if(tableOperation.equals("del")) {
            if(id != null) {
                busertable.setbId(Integer.parseInt(id));
                buService.delBusertable(busertable);
            }
            request.setAttribute("busertablesList", buService.getBusertable());
            dispatcher = request.getRequestDispatcher("/BusertableDelManagement.jsp");
        }
    }
    
    public int judgePromary(String proName) throws Exception {
        Promary promary = new Promary();
        List<Promary> promarysList = prService.getPromary();
        
        for(int i = 0; i < promarysList.size(); i++) {
            if(promarysList.get(i).getProName().equals(proName)) {
                return promarysList.get(i).getProId();
            }
        }
        
        promary.setProName(proName);
        prService.addPromary(promary);
        
        promarysList = prService.getPromary();
        
        for(int i = 0; i < promarysList.size(); i++) {
            if(promarysList.get(i).getProName().equals(proName)) {
                return promarysList.get(i).getProId();
            }
        }
        
        return 0;
    }
    
    public int judgeCity(String proName, String cityName) throws Exception {
        City city = new City();
        List<City> citysList = ciService.getCity();
        
        for(int i = 0; i < citysList.size(); i++) {
            if(citysList.get(i).getCityName().equals(cityName)) {
                return citysList.get(i).getCityId();
            }
        }
        
        city.setCityName(cityName);
        city.setProId(judgePromary(proName));
        ciService.addCity(city);
        
        citysList = ciService.getCity();
        
        for(int i = 0; i < citysList.size(); i++) {
            if(citysList.get(i).getCityName().equals(cityName)) {
                return citysList.get(i).getCityId();
            }
        }
        
        return 0;
    }
    
    public int judgeLabel(String lName) throws Exception {
        Label label = new Label();
        List<Label> labelsList = laService.getLabel();
        
        for(int i = 0; i < labelsList.size(); i++) {
            if(labelsList.get(i).getlName().equals(lName)) {
                return labelsList.get(i).getlId();
            }
        }
        
        label.setlName(lName);
        laService.addLabel(label);
        
        labelsList = laService.getLabel();
        
        for(int i = 0; i < labelsList.size(); i++) {
            if(labelsList.get(i).getlName().equals(lName)) {
                return labelsList.get(i).getlId();
            }
        }
        
        return 0;
    }
    
    public Map<Integer, Promary> getPromaryMap() throws Exception {
        List<Promary> promarysList = prService.getPromary();
        Map<Integer, Promary> promarysMap =  new HashMap<>();
        for(int i = 0; i < promarysList.size(); i++) {
            promarysMap.put(promarysList.get(i).getProId(), promarysList.get(i));
        }
        return promarysMap;
    }
    
    public Map<Integer, City> getCityMap() throws Exception {
        List<City> citysList = ciService.getCity();
        Map<Integer, City> citysMap =  new HashMap<>();
        for(int i = 0; i < citysList.size(); i++) {
            citysMap.put(citysList.get(i).getCityId(), citysList.get(i));
        }
        return citysMap;
    }
    
    public Map<Integer, Label> getLabelMap() throws Exception {
        List<Label> labelsList = laService.getLabel();
        Map<Integer, Label> labelsMap =  new HashMap<>();
        for(int i = 0; i < labelsList.size(); i++) {
            labelsMap.put(labelsList.get(i).getlId(), labelsList.get(i));
        }
        return labelsMap;
    }
    
    public void autoDelLabel() throws Exception {
        List<Label> labelsList = laService.getLabel();
        List<Attractions> attractionsList = arService.getAttractions();
        
        for(int i = 0; i < labelsList.size(); i++) {
            boolean flag = true;
            
            for(int j = 0; j < attractionsList.size(); j++) {
                if(labelsList.get(i).getlId() == attractionsList.get(j).getaLabelId()) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                laService.delLabel(labelsList.get(i));
            }
        }
    }
    
    public void autoDelCity() throws Exception {
        List<City> citysList = ciService.getCity();
        List<Attractions> attractionsList = arService.getAttractions();
        
        for(int i = 0; i < citysList.size(); i++) {
            boolean flag = true;
            
            for(int j = 0; j < attractionsList.size(); j++) {
                if(citysList.get(i).getCityId() == attractionsList.get(j).getaCityId()) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                ciService.delCity(citysList.get(i));
            }
        }
    }
    
    public void autoDelPromary() throws Exception {
        List<Promary> promarysList = prService.getPromary();
        List<City> citysList = ciService.getCity();
        
        for(int i = 0; i < promarysList.size(); i++) {
            boolean flag = true;
            
            for(int j = 0; j < citysList.size(); j++) {
                if(promarysList.get(i).getProId() == citysList.get(j).getProId()) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                prService.delPromary(promarysList.get(i));
            }
        }
    }
    
    public void judgeAttractions(String tableOperation) throws Exception {
        Attractions attractions = new Attractions();
        
        String proName = request.getParameter("proName");
        String cityName = request.getParameter("cityName");
        String lName = request.getParameter("lName");
        
        String id = request.getParameter("id");
        String aName = request.getParameter("aName");
        String aPicture = request.getParameter("aPicture");
        String aBstract = request.getParameter("aBstract");
        String aUnitPrice = request.getParameter("aUnitPrice");
        String aCostContent = request.getParameter("aCostContent");
        String aScore = request.getParameter("aScore");
        
        if(tableOperation == null) {
            dispatcher = request.getRequestDispatcher("/AttractionsAddManagement.jsp");
            request.setAttribute("attractionsList", arService.getAttractions());
        }else if(tableOperation.equals("add")) {
            if(proName != null && cityName != null && lName != null && aName != null && aPicture != null && aBstract != null && aUnitPrice != null && aCostContent != null && aScore != null) {
                attractions.setaName(aName);
                attractions.setaPicture(aPicture);
                attractions.setaBstract(aBstract);
                attractions.setaUnitPrice(Double.parseDouble(aUnitPrice));
                attractions.setaCostContent(aCostContent);
                attractions.setaScore(aScore);
                attractions.setaCityId(judgeCity(proName, cityName));
                attractions.setaLabelId(judgeLabel(lName));
                arService.addAttractions(attractions);
            }
            dispatcher = request.getRequestDispatcher("/AttractionsAddManagement.jsp");
            request.setAttribute("attractionsList", arService.getAttractions());
        }else if(tableOperation.equals("modOne")) {
            if(id != null) {
                dispatcher = request.getRequestDispatcher("/AttractionsModManagementTwo.jsp");
                List<Attractions> attractionsList = arService.getAttractions();
                for(int i = 0; i < attractionsList.size(); i++) {
                    if(Integer.parseInt(id) == attractionsList.get(i).getaId()) {
                        request.setAttribute("attractions", attractionsList.get(i));
                        break;
                    }
                }
            }else{
                dispatcher = request.getRequestDispatcher("/AttractionsModManagementOne.jsp");
                request.setAttribute("attractionsList", arService.getAttractions());
            }
        }else if(tableOperation.equals("modTwo")) {
//             writeToLog("aaaaaaaaa");
            if(id != null && proName != null && cityName != null && lName != null && aName != null && aPicture != null && aBstract != null && aUnitPrice != null && aCostContent != null && aScore != null) {
//                 writeToLog("bbbbbbbbb");
                attractions.setaId(Integer.parseInt(id));
                attractions.setaName(aName);
                attractions.setaPicture(aPicture);
                attractions.setaBstract(aBstract);
                attractions.setaUnitPrice(Double.parseDouble(aUnitPrice));
                attractions.setaCostContent(aCostContent);
                attractions.setaScore(aScore);
                attractions.setaCityId(judgeCity(proName, cityName));
                attractions.setaLabelId(judgeLabel(lName));
//                 writeToLog(judgeCity(proName, cityName));
//                 writeToLog(judgeLabel(lName));
//                 writeToLog("--------------------");
                arService.modAttractions(attractions);
//                 writeToLog("cccccccccc");
            }
            request.setAttribute("attractionsList", arService.getAttractions());
            dispatcher = request.getRequestDispatcher("/AttractionsModManagementOne.jsp");
        }else if(tableOperation.equals("del")) {
            if(id != null) {
                attractions.setaId(Integer.parseInt(id));
                arService.delAttractions(attractions);
                
                autoDelLabel();
                autoDelCity();
                autoDelPromary();
            }
            request.setAttribute("attractionsList", arService.getAttractions());
            dispatcher = request.getRequestDispatcher("/AttractionsDelManagement.jsp");
        }
        
        request.setAttribute("promarysMap", getPromaryMap());
        request.setAttribute("citysMap", getCityMap());
        request.setAttribute("labelsMap", getLabelMap());
    }
    
    public int judgeTheAttractions(String aName) throws Exception {
        List<Attractions> attractionsList = arService.getAttractions();
        
        for(int i = 0; i < attractionsList.size(); i++) {
            if(attractionsList.get(i).getaName().equals(aName)) {
                return attractionsList.get(i).getaId();
            }
        }
        
        return 0;
    }
    
    public Map<Integer, Attractions> getAttractionsMap() throws Exception {
        List<Attractions> attractionsList = arService.getAttractions();
        Map<Integer, Attractions> attractionsMap =  new HashMap<>();
        for(int i = 0; i < attractionsList.size(); i++) {
            attractionsMap.put(attractionsList.get(i).getaId(), attractionsList.get(i));
        }
        return attractionsMap;
    }
    
    public void judgeMembership(String tableOperation) throws Exception {
        Membership membership = new Membership();
        
        String aName = request.getParameter("aName");
        
        String id = request.getParameter("id");
        String mName = request.getParameter("mName");
        String mPrice = request.getParameter("mPrice");
        
        if(tableOperation == null) {
            dispatcher = request.getRequestDispatcher("/MembershipAddManagement.jsp");
            request.setAttribute("membershipsList", meService.getMembership());
        }else if(tableOperation.equals("add")) {
            if(mName != null && mPrice != null && aName != null) {
                membership.setmName(mName);
                membership.setmPrice(Double.parseDouble(mPrice));
                membership.setmAttractionsId(judgeTheAttractions(aName));
                meService.addMembership(membership);
            }
            dispatcher = request.getRequestDispatcher("/MembershipAddManagement.jsp");
            request.setAttribute("membershipsList", meService.getMembership());
        }else if(tableOperation.equals("modOne")) {
            if(id != null) {
                dispatcher = request.getRequestDispatcher("/MembershipModManagementTwo.jsp");
                List<Membership> membershipsList = meService.getMembership();
                for(int i = 0; i < membershipsList.size(); i++) {
                    if(Integer.parseInt(id) == membershipsList.get(i).getmId()) {
                        request.setAttribute("membership", membershipsList.get(i));
                        break;
                    }
                }
            }else{
                dispatcher = request.getRequestDispatcher("/MembershipModManagementOne.jsp");
                request.setAttribute("membershipsList", meService.getMembership());
            }
        }else if(tableOperation.equals("modTwo")) {
            if(id != null && mName != null && mPrice != null && aName != null) {
                membership.setmId(Integer.parseInt(id));
                membership.setmName(mName);
                membership.setmPrice(Double.parseDouble(mPrice));
                membership.setmAttractionsId(judgeTheAttractions(aName));
                meService.modMembership(membership);
            }
            request.setAttribute("membershipsList", meService.getMembership());
            dispatcher = request.getRequestDispatcher("/MembershipModManagementOne.jsp");
        }else if(tableOperation.equals("del")) {
            if(id != null) {
                membership.setmId(Integer.parseInt(id));
                meService.delMembership(membership);
            }
            request.setAttribute("membershipsList", meService.getMembership());
            dispatcher = request.getRequestDispatcher("/MembershipDelManagement.jsp");
        }
        
        request.setAttribute("attractionsMap", getAttractionsMap());
    }
    
    public int judgeTheBusertable(String bNumber) throws Exception {
        List<Busertable> busertablesList = buService.getBusertable();
        
        for(int i = 0; i < busertablesList.size(); i++) {
            if(busertablesList.get(i).getbNumber().equals(bNumber)) {
                return busertablesList.get(i).getbId();
            }
        }
        
        return 0;
    }
    
    public Map<Integer, Busertable> getBusertableMap() throws Exception {
        List<Busertable> busertablesList = buService.getBusertable();
        Map<Integer, Busertable> busertablesMap =  new HashMap<>();
        for(int i = 0; i < busertablesList.size(); i++) {
            busertablesMap.put(busertablesList.get(i).getbId(), busertablesList.get(i));
        }
        return busertablesMap;
    }
    
    public void judgeStrategy(String tableOperation) throws Exception {
        Strategy strategy = new Strategy();
        
        String bNumber = request.getParameter("bNumber");
        
        String id = request.getParameter("id");
        String sTitle = request.getParameter("sTitle");
        String sText = request.getParameter("sText");
        String sDataTime = request.getParameter("sDataTime");
        String sPlace = request.getParameter("sPlace");
        String sReading = request.getParameter("sReading");
        
        if(tableOperation == null) {
            dispatcher = request.getRequestDispatcher("/StrategyAddManagement.jsp");
            request.setAttribute("strategysList", stService.getStrategy());
        }else if(tableOperation.equals("add")) {
            if(bNumber != null && sTitle != null && sText != null && sDataTime != null && sPlace != null && sReading != null) {
                String str[] = sDataTime.split("/");
                sDataTime = str[2] + "-" + str[0] + "-" + str[1];
                
                strategy.setsTitle(sTitle);
                strategy.setsText(sText);
                strategy.setsDataTime(sDataTime);
                strategy.setsPlace(sPlace);
                strategy.setsReading(sReading);
                strategy.setsBUserTableId(judgeTheBusertable(bNumber));
                stService.addStrategy(strategy);
            }
            dispatcher = request.getRequestDispatcher("/StrategyAddManagement.jsp");
            request.setAttribute("strategysList", stService.getStrategy());
        }else if(tableOperation.equals("modOne")) {
            if(id != null) {
                dispatcher = request.getRequestDispatcher("/StrategyModManagementTwo.jsp");
                List<Strategy> strategysList = stService.getStrategy();
                for(int i = 0; i < strategysList.size(); i++) {
                    if(Integer.parseInt(id) == strategysList.get(i).getsId()) {
//                         String str[] = strategysList.get(i).getsDataTime().split(" ");
//                         strategysList.get(i).setsDataTime(str[0]);
                        request.setAttribute("strategy", strategysList.get(i));
                        break;
                    }
                }
            }else{
                dispatcher = request.getRequestDispatcher("/StrategyModManagementOne.jsp");
                request.setAttribute("strategysList", stService.getStrategy());
            }
        }else if(tableOperation.equals("modTwo")) {
            if(id != null && bNumber != null && sTitle != null && sText != null && sDataTime != null && sPlace != null && sReading != null) {
                strategy.setsId(Integer.parseInt(id));
                strategy.setsTitle(sTitle);
                strategy.setsText(sText);
                strategy.setsDataTime(sDataTime);
                strategy.setsPlace(sPlace);
                strategy.setsReading(sReading);
                strategy.setsBUserTableId(judgeTheBusertable(bNumber));
                stService.modStrategy(strategy);
            }
            request.setAttribute("strategysList", stService.getStrategy());
            dispatcher = request.getRequestDispatcher("/StrategyModManagementOne.jsp");
        }else if(tableOperation.equals("del")) {
            if(id != null) {
                strategy.setsId(Integer.parseInt(id));
                stService.delStrategy(strategy);
            }
            request.setAttribute("strategysList", stService.getStrategy());
            dispatcher = request.getRequestDispatcher("/StrategyDelManagement.jsp");
        }
        
        request.setAttribute("busertablesMap", getBusertableMap());
    }
    
    public void judgeAttention(String tableOperation) throws Exception {
        Attention attention = new Attention();
        
        String aName = request.getParameter("aName");
        String bNumber = request.getParameter("bNumber");
        
        String id = request.getParameter("id");
        String aData = request.getParameter("aData");
        
        if(tableOperation == null) {
            dispatcher = request.getRequestDispatcher("/AttentionAddManagement.jsp");
            request.setAttribute("attentionsList", aeService.getAttention());
        }else if(tableOperation.equals("add")) {
            if(aName != null && bNumber != null && aData != null) {
                String str[] = aData.split("/");
                aData = str[2] + "-" + str[0] + "-" + str[1];
                
                attention.setaData(aData);
                attention.setaAttractionsId(judgeTheAttractions(aName));
                attention.setaBUserTableId(judgeTheBusertable(bNumber));
                aeService.addAttention(attention);
            }
            dispatcher = request.getRequestDispatcher("/AttentionAddManagement.jsp");
            request.setAttribute("attentionsList", aeService.getAttention());
        }else if(tableOperation.equals("modOne")) {
            if(id != null) {
                dispatcher = request.getRequestDispatcher("/AttentionModManagementTwo.jsp");
                List<Attention> attentionsList = aeService.getAttention();
                for(int i = 0; i < attentionsList.size(); i++) {
                    if(Integer.parseInt(id) == attentionsList.get(i).getaId()) {
//                         String str[] = attentionsList.get(i).getaData().split(" ");
//                         attentionsList.get(i).setaData(str[0]);
                        request.setAttribute("attention", attentionsList.get(i));
                        break;
                    }
                }
            }else{
                dispatcher = request.getRequestDispatcher("/AttentionModManagementOne.jsp");
                request.setAttribute("attentionsList", aeService.getAttention());
            }
        }else if(tableOperation.equals("modTwo")) {
            if(id != null && aName != null && bNumber != null && aData != null) {
                attention.setaId(Integer.parseInt(id));
                attention.setaData(aData);
                attention.setaAttractionsId(judgeTheAttractions(aName));
                attention.setaBUserTableId(judgeTheBusertable(bNumber));
                aeService.modAttention(attention);
            }
            request.setAttribute("attentionsList", aeService.getAttention());
            dispatcher = request.getRequestDispatcher("/AttentionModManagementOne.jsp");
        }else if(tableOperation.equals("del")) {
            if(id != null) {
                attention.setaId(Integer.parseInt(id));
                aeService.delAttention(attention);
            }
            request.setAttribute("attentionsList", aeService.getAttention());
            dispatcher = request.getRequestDispatcher("/AttentionDelManagement.jsp");
        }
        
        request.setAttribute("attractionsMap", getAttractionsMap());
        request.setAttribute("busertablesMap", getBusertableMap());
    }
    
    public void judgeUserevaluation(String tableOperation) throws Exception {
        Userevaluation userevaluation = new Userevaluation();
        
        String aName = request.getParameter("aName");
        String bNumber = request.getParameter("bNumber");
        
        String id = request.getParameter("id");
        String uEvaluationText = request.getParameter("uEvaluationText");
        String uPicture = request.getParameter("uPicture");
        String uData = request.getParameter("uData");
        
        if(tableOperation == null) {
            dispatcher = request.getRequestDispatcher("/UserevaluationAddManagement.jsp");
            request.setAttribute("userevaluationsList", usService.getUserevaluation());
        }else if(tableOperation.equals("add")) {
            if(aName != null && bNumber != null && uEvaluationText != null && uPicture != null && uData != null) {
                String str[] = uData.split("/");
                uData = str[2] + "-" + str[0] + "-" + str[1];
                
                userevaluation.setuEvaluationText(uEvaluationText);
                userevaluation.setuPrcture(uPicture);
                userevaluation.setuData(uData);
                userevaluation.setuAttractionsId(judgeTheAttractions(aName));
                userevaluation.setuBUserTableId(judgeTheBusertable(bNumber));
                usService.addUserevaluation(userevaluation);
            }
            dispatcher = request.getRequestDispatcher("/UserevaluationAddManagement.jsp");
            request.setAttribute("userevaluationsList", usService.getUserevaluation());
        }else if(tableOperation.equals("modOne")) {
            if(id != null) {
                dispatcher = request.getRequestDispatcher("/UserevaluationModManagementTwo.jsp");
                List<Userevaluation> userevaluationsList = usService.getUserevaluation();
                for(int i = 0; i < userevaluationsList.size(); i++) {
                    if(Integer.parseInt(id) == userevaluationsList.get(i).getuId()) {
//                         String str[] = userevaluationsList.get(i).getuData().split(" ");
//                         userevaluationsList.get(i).setuData(str[0]);
                        request.setAttribute("userevaluation", userevaluationsList.get(i));
                        break;
                    }
                }
            }else{
                dispatcher = request.getRequestDispatcher("/UserevaluationModManagementOne.jsp");
                request.setAttribute("userevaluationsList", usService.getUserevaluation());
            }
        }else if(tableOperation.equals("modTwo")) {
            if(id != null && aName != null && bNumber != null && uEvaluationText != null && uPicture != null && uData != null) {
                userevaluation.setuId(Integer.parseInt(id));
                userevaluation.setuEvaluationText(uEvaluationText);
                userevaluation.setuPrcture(uPicture);
                userevaluation.setuData(uData);
                userevaluation.setuAttractionsId(judgeTheAttractions(aName));
                userevaluation.setuBUserTableId(judgeTheBusertable(bNumber));
                usService.modUserevaluation(userevaluation);
            }
            request.setAttribute("userevaluationsList", usService.getUserevaluation());
            dispatcher = request.getRequestDispatcher("/UserevaluationModManagementOne.jsp");
        }else if(tableOperation.equals("del")) {
            if(id != null) {
                userevaluation.setuId(Integer.parseInt(id));
                usService.delUserevaluation(userevaluation);
            }
            request.setAttribute("userevaluationsList", usService.getUserevaluation());
            dispatcher = request.getRequestDispatcher("/UserevaluationDelManagement.jsp");
        }
        
        request.setAttribute("attractionsMap", getAttractionsMap());
        request.setAttribute("busertablesMap", getBusertableMap());
    }
    
    public void autoDelOrder() throws Exception {
        List<Order> ordersList = orService.getOrder();
        List<Orderdetails> orderdetailsList = odService.getOrderdetails();
        
        for(int i = 0; i < ordersList.size(); i++) {
            boolean flag = true;
            
            for(int j = 0; j < orderdetailsList.size(); j++) {
                if(ordersList.get(i).getoId() == orderdetailsList.get(j).getdOrderId()) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                orService.delOrder(ordersList.get(i));
            }
        }
    }
    
    public int judgeOrder(String bNumber, String oPrice, String oState, String oData) throws Exception {
        Order order = new Order();
        List<Order> ordersList = orService.getOrder();
        
        if(tableOperation != null && tableOperation.equals("add")) {
            oData = oData + " 00:00:00.0";
        }
        
        for(int i = 0; i < ordersList.size(); i++) {
            if(ordersList.get(i).getoPrice() == Double.parseDouble(oPrice) && ordersList.get(i).getoState().equals(oState) && ordersList.get(i).getoData().equals(oData) && ordersList.get(i).getoBUserTableId() == judgeTheBusertable(bNumber)) {
                return ordersList.get(i).getoId();
            }
        }
        
        order.setoPrice(Double.parseDouble(oPrice));
        order.setoState(oState);
        order.setoData(oData);
        order.setoBUserTableId(judgeTheBusertable(bNumber));
        orService.addOrder(order);
        
        ordersList = orService.getOrder();
        
        for(int i = 0; i < ordersList.size(); i++) {
//             writeToLog(ordersList.get(i).getoData());
//             writeToLog(oData);
            if(ordersList.get(i).getoPrice() == Double.parseDouble(oPrice) && ordersList.get(i).getoState().equals(oState) && ordersList.get(i).getoData().equals(oData) && ordersList.get(i).getoBUserTableId() == judgeTheBusertable(bNumber)) {
                return ordersList.get(i).getoId();
            }
        }
        
        return 0;
    }
    
    public Map<Integer, Order> getOrderMap() throws Exception {
        List<Order> ordersList = orService.getOrder();
        Map<Integer, Order> ordersMap =  new HashMap<>();
        for(int i = 0; i < ordersList.size(); i++) {
//             String str[] = ordersList.get(i).getoData().split(" ");
//             ordersList.get(i).setoData(str[0]);
            ordersMap.put(ordersList.get(i).getoId(), ordersList.get(i));
        }
        return ordersMap;
    }
    
    public void judgeOrderdetails(String tableOperation) throws Exception {
        Orderdetails orderdetails = new Orderdetails();
        Order order = new Order();
        
        String bNumber = request.getParameter("bNumber");
        
        String id = request.getParameter("id");
        String oPrice = request.getParameter("oPrice");
        String oState = request.getParameter("oState");
        String oData = request.getParameter("oData");
        
        String aName = request.getParameter("aName");
        
        String number = request.getParameter("number");
        
        if(tableOperation == null) {
            dispatcher = request.getRequestDispatcher("/OrderdetailsAddManagement.jsp");
            request.setAttribute("orderdetailsList", odService.getOrderdetails());
        }else if(tableOperation.equals("add")) {
            if(bNumber != null && oPrice != null && oState != null && oData != null && aName != null && number != null) {
                String str[] = oData.split("/");
                oData = str[2] + "-" + str[0] + "-" + str[1];
//                 writeToLog(oData);
                
                orderdetails.setNumber(Integer.parseInt(number));
                orderdetails.setdAttractionsId(judgeTheAttractions(aName));
                orderdetails.setdOrderId(judgeOrder(bNumber, oPrice, oState, oData));
                odService.addOrderdetails(orderdetails);
            }
            dispatcher = request.getRequestDispatcher("/OrderdetailsAddManagement.jsp");
            request.setAttribute("orderdetailsList", odService.getOrderdetails());
        }else if(tableOperation.equals("modOne")) {
            if(id != null && aName != null && number != null) {
                dispatcher = request.getRequestDispatcher("/OrderdetailsModManagementTwo.jsp");
                List<Orderdetails> orderdetailsList = odService.getOrderdetails();
                for(int i = 0; i < orderdetailsList.size(); i++) {
                    if(Integer.parseInt(id) == orderdetailsList.get(i).getdOrderId() && judgeTheAttractions(aName) == orderdetailsList.get(i).getdAttractionsId() && Integer.parseInt(number) == orderdetailsList.get(i).getNumber()) {
                        request.setAttribute("orderdetails", orderdetailsList.get(i));
                        break;
                    }
                }
            }else{
                dispatcher = request.getRequestDispatcher("/OrderdetailsModManagementOne.jsp");
                request.setAttribute("orderdetailsList", odService.getOrderdetails());
            }
        }else if(tableOperation.equals("modTwo")) {
            if(id != null && bNumber != null && oPrice != null && oState != null && oData != null && aName != null && number != null) {
                
                order.setoId(Integer.parseInt(id));
                order.setoPrice(Double.parseDouble(oPrice));
                order.setoState(oState);
                order.setoData(oData);
                order.setoBUserTableId(judgeTheBusertable(bNumber));
//                 writeToLog("1");
                orService.modOrder(order);
//                 writeToLog("2");
                
                orderdetails.setNumber(Integer.parseInt(number));
                orderdetails.setdAttractionsId(judgeTheAttractions(aName));
                orderdetails.setdOrderId(judgeOrder(bNumber, oPrice, oState, oData));
                odService.modOrderdetails(orderdetails);
            }
            request.setAttribute("orderdetailsList", odService.getOrderdetails());
            dispatcher = request.getRequestDispatcher("/OrderdetailsModManagementOne.jsp");
        }else if(tableOperation.equals("del")) {
            if(id != null && aName != null && number != null) {
                orderdetails.setNumber(Integer.parseInt(number));
                orderdetails.setdAttractionsId(judgeTheAttractions(aName));
                orderdetails.setdOrderId(Integer.parseInt(id));
                odService.delOrderdetails(orderdetails);
                
                autoDelOrder();
            }
            request.setAttribute("orderdetailsList", odService.getOrderdetails());
            dispatcher = request.getRequestDispatcher("/OrderdetailsDelManagement.jsp");
        }
        
        request.setAttribute("attractionsMap", getAttractionsMap());
        request.setAttribute("busertablesMap", getBusertableMap());
        request.setAttribute("ordersMap", getOrderMap());
    }
    
    public void judge() throws Exception {
        request.setCharacterEncoding("utf-8");
        tableName = request.getParameter("tableName");
        tableOperation = request.getParameter("tableOperation");
        account = request.getParameter("account");
        password = request.getParameter("password");
        
        if(tableName != null && tableOperation != null) {
            if(tableName.equals("Busertable")) {
                judgeBusertable(tableOperation);
            }else if(tableName.equals("Attractions")) {
                judgeAttractions(tableOperation);
            }else if(tableName.equals("Membership")) {
                judgeMembership(tableOperation);
            }else if(tableName.equals("Strategy")) {
                judgeStrategy(tableOperation);
            }else if(tableName.equals("Attention")) {
                judgeAttention(tableOperation);
            }else if(tableName.equals("Userevaluation")) {
                judgeUserevaluation(tableOperation);
            }else if(tableName.equals("Order")) {
                judgeOrderdetails(tableOperation);
            }
        }else{
            if(account != null && password != null && account.equals("admin") && password.equals("1314520")) {
                judgeBusertable(tableOperation);
            }else{
                dispatcher = request.getRequestDispatcher("/BackgroundManagementLogin.jsp");
            }
        }
        
        dispatcher.forward(request, response);
    }
   
}