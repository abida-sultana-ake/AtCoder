import java.util.Scanner;

class Main{

    static int returnW(int dis){
        dis *= 100;
        if(dis < 25 * 60)
            return 0;
        else if(dis < 155 * 60)
            return 1;
        else if(dis < 335 * 60)
            return 2;
        else if(dis < 545 * 60)
            return 3;
        else if(dis < 795 * 60)
            return 4;
        else if(dis < 1075 * 60)
            return 5;
        else if(dis < 1385 * 60)
            return 6;
        else if(dis < 1715 * 60)
            return 7;
        else if(dis < 2075 * 60)
            return 8;
        else if(dis < 2445 * 60)
            return 9;
        else if(dis < 2845 * 60)
            return 10;
        else if(dis < 3265 * 60)
            return 11;
        else
            return 12;
    }
    static String returnDeg(int deg,int dis){
        dis *= 100;
        if(dis < 25 * 60)
            return "C";
        if(113 <= deg && deg <= 337)
            return "NNE";
        else if(338 <= deg && deg <= 562)
            return "NE";
        else if(563 <= deg && deg <= 787)
            return "ENE";
        else if(787 <= deg && deg <= 1012)
            return "E"; 
        else if(1013 <= deg && deg <= 1237)
            return "ESE";
        else if(1238 <= deg && deg <= 1462)
            return "SE";
        else if(1463 <= deg && deg <= 1687)
            return "SSE";
        else if(1688 <= deg && deg <= 1912)
            return "S";
        else if(1913 <= deg && deg <= 2137)
            return "SSW";
        else if(2137 <= deg && deg <= 2362)
            return "SW";
        else if(2363 <= deg && deg <= 2587)
            return "WSW"; 
        else if(2588 <= deg && deg <= 2812)
            return "W";
        else if(2813 <= deg && deg <= 3037)
            return "WNW";
        else if(3038 <= deg && deg <= 3262)
            return "NW";
        else if(3263 <= deg && deg <= 3487)
            return "NNW";
        else
            return "N";
    }

    /*static String returnDir(int dir,int dis){
        dis *= 100;
        if(dis < 25 * 60)
            return "C";
        String ret = "";
        if(dir <= 562){
            ret += "N";
            if(dir >= 113){
                if(dir <= 337)
                    ret+="N";
                ret+="E";
            }
        }else if(dir <= 1237){
            ret += "E";
            if(dir <= 787)
                ret += "NE";
            if(dir >= 1013)
                ret += "SE";
        }else if(dir <= 2362){
            ret += "S";
            if(dir <= 1462)
                ret += "E";
            else if(dir <= 1687)
                ret += "SE";
            else if(dir <= 2137 && dir >= 1913)
                ret += "SW";
            else
                ret += "W";
        }else if(dir <= 3037){
            ret += "W";
            if(dir <= 2587)
                ret += "SW";
            else if(dir >= 2813)
                ret += "NW";
        }
        else if(dir <= 3262)
            ret += "NW";
        else if(dir <= 3487)
            ret += "NNW";
        else
            ret += "N";
        return ret;
    }*/

    public static void main(String[] arge){
        Scanner scan = new Scanner(System.in);
        int deg,dis;
        deg = scan.nextInt();
        dis = scan.nextInt();
        System.out.println(returnDeg(deg,dis) + " " + returnW(dis));
    }
}
