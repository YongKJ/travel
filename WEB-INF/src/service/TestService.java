
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class TestService {
    
    public HttpServletRequest request;
    public HttpServletResponse response;
    public PrintWriter out;
    
    public DataService data;
    public String tableName;
    public String tableOperation;
    
    public TestService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        
        data = new DataService(request.getSession().getServletContext().getRealPath(""));
        tableName = null;
        tableOperation = null;
    }
    
    public void judgeAttention() throws Exception {
        AttentionService aeService = new AttentionService();
        
//         Attention attention = data.getAttentionData("add");
//         out.write(attention.getaId() + " ");
//         out.write(attention.getaData() + " ");
//         out.write(attention.getaAttractionsId() + " ");
//         out.write(attention.getaBUserTableId() + "\n\n");
        
        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(aeService.addAttention(data.getAttentionData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(aeService.modAttention(data.getAttentionData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(aeService.delAttention(data.getAttentionData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<Attention> attentionsList = aeService.getAttention();
        out.write("表中总共有" + attentionsList.size() + "条数据。\n\n");
        for(int i = 0; i < attentionsList.size(); i++) {
            out.write(attentionsList.get(i).getaId() + " ");
            out.write(attentionsList.get(i).getaData() + " ");
            out.write(attentionsList.get(i).getaAttractionsId() + " ");
            out.write(attentionsList.get(i).getaBUserTableId() + (i == attentionsList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judgeAttractions() throws Exception {
        AttractionsService arService = new AttractionsService();
        
        Attractions attractions = data.getAttractionsData("add");
        out.write(attractions.getaId() + " ");
        out.write(attractions.getaName() + " ");
        out.write(attractions.getaPicture() + " ");
        out.write(attractions.getaBstract() + " ");
        out.write(attractions.getaUnitPrice() + " ");
        out.write(attractions.getaCostContent() + " ");
        out.write(attractions.getaScore() + " ");
        out.write(attractions.getaLabelId() + " ");
        out.write(attractions.getaCityId() + "\n\n");

        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(arService.addAttractions(data.getAttractionsData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(arService.modAttractions(data.getAttractionsData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(arService.delAttractions(data.getAttractionsData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<Attractions> attractionsList = arService.getAttractions();
        out.write("表中总共有" + attractionsList.size() + "条数据。\n\n");
        for(int i = 0; i < attractionsList.size(); i++) {
            out.write(attractionsList.get(i).getaId() + " ");
            out.write(attractionsList.get(i).getaName() + " ");
            out.write(attractionsList.get(i).getaPicture() + " ");
            out.write(attractionsList.get(i).getaBstract() + " ");
            out.write(attractionsList.get(i).getaUnitPrice() + " ");
            out.write(attractionsList.get(i).getaCostContent() + " ");
            out.write(attractionsList.get(i).getaScore() + " ");
            out.write(attractionsList.get(i).getaLabelId() + " ");
            out.write(attractionsList.get(i).getaCityId() + (i == attractionsList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judgeBusertable() throws Exception {
        BusertableService buService = new BusertableService();
        
//         Busertable busertable = data.getBusertableData("add");
//         out.write(busertable.getbId() + " ");
//         out.write(busertable.getbNumber() + " ");
//         out.write(busertable.getbPWD() + " ");
//         out.write(busertable.getbName() + " ");
//         out.write(busertable.getbEmail() + " ");
//         out.write(busertable.getrName() + " ");
//         out.write(busertable.getbSex() + " ");
//         out.write(busertable.getBirthday() + " ");
//         out.write(busertable.getbPhone() + "\n\n");
        
        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(buService.addBusertable(data.getBusertableData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(buService.modBusertable(data.getBusertableData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(buService.delBusertable(data.getBusertableData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<Busertable> busertablesList = buService.getBusertable();
        out.write("表中总共有" + busertablesList.size() + "条数据。\n\n");
        for(int i = 0; i < busertablesList.size(); i++) {
            out.write(busertablesList.get(i).getbId() + " ");
            out.write(busertablesList.get(i).getbNumber() + " ");
            out.write(busertablesList.get(i).getbPWD() + " ");
            out.write(busertablesList.get(i).getbName() + " ");
            out.write(busertablesList.get(i).getbEmail() + " ");
            out.write(busertablesList.get(i).getrName() + " ");
            out.write(busertablesList.get(i).getbSex() + " ");
            out.write(busertablesList.get(i).getBirthday() + " ");
            out.write(busertablesList.get(i).getbPhone() + (i == busertablesList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judgeCity() throws Exception {
        CityService ciService = new CityService();
        
//         City city = data.getCityData("del");
//         out.write(city.getCityId() + " ");
//         out.write(city.getCityName() + " ");
//         out.write(city.getProId() + "\n\n");
        
        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(ciService.addCity(data.getCityData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(ciService.modCity(data.getCityData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(ciService.delCity(data.getCityData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<City> citysList = ciService.getCity();
        out.write("表中总共有" + citysList.size() + "条数据。\n\n");
        for(int i = 0; i < citysList.size(); i++) {
            out.write(citysList.get(i).getCityId() + " ");
            out.write(citysList.get(i).getCityName() + " ");
            out.write(citysList.get(i).getProId() + (i == citysList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judgeLabel() throws Exception {
        LabelService laService = new LabelService();
        
        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(laService.addLabel(data.getLabelData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(laService.modLabel(data.getLabelData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(laService.delLabel(data.getLabelData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<Label> labelsList = laService.getLabel();
        out.write("表中总共有" + labelsList.size() + "条数据。\n\n");
        for(int i = 0; i < labelsList.size(); i++) {
            out.write(labelsList.get(i).getlId() + " ");
            out.write(labelsList.get(i).getlName() + (i == labelsList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judgeMembership() throws Exception {
        MembershipService meService = new MembershipService();
        
        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(meService.addMembership(data.getMembershipData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(meService.modMembership(data.getMembershipData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(meService.delMembership(data.getMembershipData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<Membership> membershipsList = meService.getMembership();
        out.write("表中总共有" + membershipsList.size() + "条数据。\n\n");
        for(int i = 0; i < membershipsList.size(); i++) {
            out.write(membershipsList.get(i).getmId() + " ");
            out.write(membershipsList.get(i).getmName() + " ");
            out.write(membershipsList.get(i).getmPrice() + " ");
            out.write(membershipsList.get(i).getmAttractionsId() + (i == membershipsList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judgeOrder() throws Exception {
        OrderService orService = new OrderService();
        
        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(orService.addOrder(data.getOrderData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(orService.modOrder(data.getOrderData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(orService.delOrder(data.getOrderData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<Order> ordersList = orService.getOrder();
        out.write("表中总共有" + ordersList.size() + "条数据。\n\n");
        for(int i = 0; i < ordersList.size(); i++) {
            out.write(ordersList.get(i).getoId() + " ");
            out.write(ordersList.get(i).getoPrice() + " ");
            out.write(ordersList.get(i).getoState() + " ");
            out.write(ordersList.get(i).getoData() + " ");
            out.write(ordersList.get(i).getoBUserTableId() + (i == ordersList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judgeOrderdetails() throws Exception {
        OrderdetailsService odService = new OrderdetailsService();
        
        Orderdetails orderdetails = data.getOrderdetailsData("add");
        out.write(orderdetails.getNumber() + " ");
        out.write(orderdetails.getdAttractionsId() + " ");
        out.write(orderdetails.getdOrderId() + "\n\n");
        
        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(odService.addOrderdetails(data.getOrderdetailsData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(odService.modOrderdetails(data.getOrderdetailsData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(odService.delOrderdetails(data.getOrderdetailsData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<Orderdetails> orderdetailsList = odService.getOrderdetails();
        out.write("表中总共有" + orderdetailsList.size() + "条数据。\n\n");
        for(int i = 0; i < orderdetailsList.size(); i++) {
            out.write(orderdetailsList.get(i).getNumber() + " ");
            out.write(orderdetailsList.get(i).getdAttractionsId() + " ");
            out.write(orderdetailsList.get(i).getdOrderId() + (i == orderdetailsList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judgePromary() throws Exception {
        PromaryService prService = new PromaryService();
        
        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(prService.addPromary(data.getPromaryData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(prService.modPromary(data.getPromaryData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(prService.delPromary(data.getPromaryData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<Promary> promarysList = prService.getPromary();
        out.write("表中总共有" + promarysList.size() + "条数据。\n\n");
        for(int i = 0; i < promarysList.size(); i++) {
            out.write(promarysList.get(i).getProId() + " ");
            out.write(promarysList.get(i).getProName() + (i == promarysList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judgeStrategy() throws Exception {
        StrategyService stService = new StrategyService();
        
        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(stService.addStrategy(data.getStrategyData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(stService.modStrategy(data.getStrategyData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(stService.delStrategy(data.getStrategyData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<Strategy> strategysList = stService.getStrategy();
        out.write("表中总共有" + strategysList.size() + "条数据。\n\n");
        for(int i = 0; i < strategysList.size(); i++) {
            out.write(strategysList.get(i).getsId() + " ");
            out.write(strategysList.get(i).getsTitle() + " ");
            out.write(strategysList.get(i).getsText() + " ");
            out.write(strategysList.get(i).getsDataTime() + " ");
            out.write(strategysList.get(i).getsPlace() + " ");
            out.write(strategysList.get(i).getsReading() + " ");
            out.write(strategysList.get(i).getsBUserTableId() + (i == strategysList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judgeUserevaluation() throws Exception {
        UserevaluationService usService = new UserevaluationService();
        
        if(tableOperation == null) {
            out.write("查看数据信息！\n\n");
        }else if(tableOperation.equals("add")) {
            if(usService.addUserevaluation(data.getUserevaluationData("add"))) {
                out.write("数据添加成功！\n\n");
            }else{
                out.write("数据添加失败！\n\n");
            }
        }else if(tableOperation.equals("mod")) {
            if(usService.modUserevaluation(data.getUserevaluationData("mod"))) {
                out.write("数据修改成功！\n\n");
            }else{
                out.write("数据修改失败！\n\n");
            }
        }else if(tableOperation.equals("del")) {
            if(usService.delUserevaluation(data.getUserevaluationData("del"))) {
                out.write("数据删除成功！\n\n");
            }else{
                out.write("数据删除失败！\n\n");
            }
        }else{
            out.write("查看数据信息！\n\n");
        }
        
        List<Userevaluation> userevaluationsList = usService.getUserevaluation();
        out.write("表中总共有" + userevaluationsList.size() + "条数据。\n\n");
        for(int i = 0; i < userevaluationsList.size(); i++) {
            out.write(userevaluationsList.get(i).getuId() + " ");
            out.write(userevaluationsList.get(i).getuEvaluationText() + " ");
            out.write(userevaluationsList.get(i).getuPicture() + " ");
            out.write(userevaluationsList.get(i).getuData() + " ");
            out.write(userevaluationsList.get(i).getuAttractionsId() + " ");
            out.write(userevaluationsList.get(i).getuBUserTableId() + (i == userevaluationsList.size() - 1 ? "\n\n" : "\n"));
        }
    }
    
    public void judge() throws Exception {
        response.setCharacterEncoding("gbk");
        out = response.getWriter();
        tableName = request.getParameter("tableName");
        tableOperation = request.getParameter("tableOperation");
        
        if(tableName == null) {
            out.write("欢迎测试数据库的增删查改功能！\n\n请选择要进行的操作！\n\n例子：http://47.106.102.217:8080/travel/test?tableName=promary&tableOperation=add\n\n");
        }else if(tableName.equals("attention")) {
            judgeAttention();
        }else if(tableName.equals("attractions")) {
            judgeAttractions();
        }else if(tableName.equals("busertable")) {
            judgeBusertable();
        }else if(tableName.equals("city")) {
            judgeCity();
        }else if(tableName.equals("label")) {
            judgeLabel();
        }else if(tableName.equals("membership")) {
            judgeMembership();
        }else if(tableName.equals("order")) {
            judgeOrder();
        }else if(tableName.equals("orderdetails")) {
            judgeOrderdetails();
        }else if(tableName.equals("promary")) {
            judgePromary();
        }else if(tableName.equals("strategy")) {
            judgeStrategy();
        }else if(tableName.equals("userevaluation")) {
            judgeUserevaluation();
        }else{
            out.write("请输入正确的操作信息！\n\n");
        }
    }
    
}