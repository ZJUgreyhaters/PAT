import java.util.Scanner;

/**
 * @ClassName: Money
 * @Description: TODO
 * @Author: wbchen
 * @Date: 2018/10/11 12:53
 * @Version 1.0.0
 **/

public class Money{

    //雇员交的养老保险比率
    public static final double OldRateSelf = 0.08;
    //雇员交的医疗保险比率
    public static final double MedicalRateSelf = 0.02;
    //雇员交的失业保险比率
    public static final double JobRateSelf = 0.002;
    //雇员交的住房公积金比率
    public static final double BuildingRateSelf = 0.12;
    //个人交的总额比率
    public static final double totalSelf = OldRateSelf + BuildingRateSelf + MedicalRateSelf + JobRateSelf;


    //公司交的养老保险金比率
    public static final double OldRateCompany = 0.2;
    //公司交的医疗保险比率
    public static final double MedicalRateCompany = 0.1;
    //公司交的失业保险比率
    public static final double JobRateCompany = 0.01;
    //公司交的生育和工伤保险比率
    public static final double HurtAndBirthRateCompany = 0.011;
    //公司交的住房公积金比率
    public static final double BuildingRateCompany = 0.12;
    //公司交的总额比率
    public static final double totalCompany = OldRateCompany + MedicalRateCompany + JobRateCompany + HurtAndBirthRateCompany + BuildingRateCompany;


    public static void main(String[] args){

        System.out.printf("个人总的比率：%.3f\n" +
                "公司总的比率: %.3f\n", totalSelf, totalCompany);
//--------------------工资计算---------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        System.out.print("税前每月工资：");
        double rawMoneyEveryMonth = scanner.nextDouble();
        System.out.print("总月数：");
        int totalMonth = scanner.nextInt();

        System.out.println("\n税前每月工资：" + rawMoneyEveryMonth);
        System.out.println("总月数：" + totalMonth);

        System.out.printf("个人五险一金总额：%.3f\n公司五险一金总额：%.3f\n",
                rawMoneyEveryMonth * totalSelf * 12, rawMoneyEveryMonth * totalCompany * 12);

        double getMoney = rawMoneyEveryMonth * (1 - totalSelf);
        double needTax = getMoney - 5000;
        double submitTax = 0;

        if(needTax <= 3000){
            submitTax = needTax * 0.03;
        }else if(needTax <= 12000){
            submitTax = needTax * 0.1 - 210;
        }else if(needTax <= 25000){
            submitTax = needTax * 0.2 - 1410;
        }else if(needTax <= 35000){
            submitTax = needTax * 0.25 - 2660;
        }else if(needTax <= 55000){
            submitTax = needTax * 0.3 -4410;
        }else if(needTax <= 80000){
            submitTax = needTax * 0.35 - 7160;
        }else{
            submitTax = needTax * 0.45 - 15160;
        }
        getMoney -= submitTax;
        double totalGetMoney = getMoney * 12;
        System.out.println("每月个人五险一金：" + rawMoneyEveryMonth * totalSelf);
        System.out.println("每月公司五险一金：" + rawMoneyEveryMonth * totalCompany);
        System.out.println("每月缴纳税额: " + submitTax);
        System.out.println("每月到手的钱: " + getMoney);
        System.out.println("每年总的到手的钱：" + totalGetMoney);
//-----------------年终奖计算---------------------------------------------------------------
        if(totalMonth < 12){
            return;
        }
        int bonusMonth = totalMonth - 12;
        needTax = bonusMonth * rawMoneyEveryMonth / 12;
        double submitTaxOfBouns;
        if(needTax <= 3000){
            submitTaxOfBouns = needTax * 0.03;
        }else if(needTax <= 12000){
            submitTaxOfBouns = needTax * 0.1 - 210;
        }else if(needTax <= 25000){
            submitTaxOfBouns = needTax * 0.2 - 1410;
        }else if(needTax <= 35000){
            submitTaxOfBouns = needTax * 0.25 - 2660;
        }else if(needTax <= 55000){
            submitTaxOfBouns = needTax * 0.3 -4410;
        }else if(needTax <= 80000){
            submitTaxOfBouns = needTax * 0.35 - 7160;
        }else{
            submitTaxOfBouns = needTax * 0.45 - 15160;
        }
        System.out.println("年终奖月份：" + bonusMonth);
        System.out.println("年终奖交税：" + submitTaxOfBouns * 12);
        System.out.println("年终奖到手：" + (bonusMonth * rawMoneyEveryMonth - submitTaxOfBouns * 12));

        System.out.println("-------------------------\n打包：" +
                (totalGetMoney +
                        (bonusMonth * rawMoneyEveryMonth - submitTaxOfBouns * 12) +
                        rawMoneyEveryMonth * (totalSelf + totalCompany)* 12) +
                        "\n到手的钱：" + 
                        (totalGetMoney + 
                        	(bonusMonth * rawMoneyEveryMonth - submitTaxOfBouns * 12)) +
                        "\n ======================================\n");
    }
}