

import java.util.Scanner;
public class EB_Bill_Generator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Number Of Inputs");
    int n = sc.nextInt();
    double arr[] = new double[n];
    for(int i =0;i<n;i++) {
      System.out.println(i+1+".Enter Units: ");
      double units = sc.nextDouble();
      arr[i] = units;
    }
    double total_old_year = 0;
    double total_new_year = 0;
    String line = "---------------------------------------------------------------------------------------";
    System.out.println(line);
    System.out.format("|%15s|%15s|%17s |%17s |%15s|\n", "MONTHS","UNITS","OLD TARIFF 2021","NEW TARIFF 2022","HIKE");
    System.out.println(line);
    int month = 1;
    for(int i=0;i<arr.length;i++) {
      double old_price = Old_Tariff_for_2021(arr[i]);
      double new_price = New_Tariff_for_2022(arr[i]);
      System.out.format("|%15s|%15s|%17s |%17s |%15s|\n",(month++)+","+(month++),arr[i],old_price,new_price,(new_price-old_price));
      System.out.println(line);
      total_old_year += old_price;
      total_new_year += new_price;
    }
    System.out.println("\n Yearly Total Cost:  \n\t For 2021- Rs."+total_old_year+" \n\t For 2022- Rs."+total_new_year);
    System.out.println("\n Yearly Average Cost:  \n\t For 2021- Rs."+(total_old_year/arr.length)+" \n\t For 2022-Rs."+(total_new_year/arr.length));
  }

  private static double Old_Tariff_for_2021(double units) {
    if(units <= 100) {
      return 0;
    }
    if (units > 100 && units <= 200) {
      return ((units-100) * 1.5 + 20);
    }
    if(units > 200 && units <= 500) {
      return((units - 200) * 3 + 200 + 30);
    }
    if(units > 500) {
      return((units - 500) * 6.6 + 350 + 1380 + 50);
    }
    return units;
  }

  private static double New_Tariff_for_2022(double units) {
    if (units <= 500) {
      if(units <= 100) {
        return 0;
      }
      if(units > 100 && units <= 200) {
        return((units - 100) * 2.25);
      }
      if(units > 200 && units <= 400) {
        return((units - 200) * 4.5 + 225);
      }
      if(units > 400 && units <= 500) {
        return((units - 400) * 6 + 225 + 900);
      }
      if(units > 500 && units <= 600) {
        return((units - 500) * 8 + 600 + 1350);
      }
      if(units > 600 && units <= 800) {
        return((units - 600) * 9 + 600 + 1350 + 800);
      }
      if(units > 800 && units <= 1000) {
        return((units - 800) * 10 + 600 + 1350 + 800 + 1800);
      }
      if(units > 1000) {
        return((units - 1000) * 11 + 600 + 1350 + 800 + 1800 + 2000);
      }
    }
    return units;

  }
}