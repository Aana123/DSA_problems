public class Integer_to_Roman {
    public static void main(String[] args) {
        int num = 1999;
        System.out.println(intToRoman(num));
    }

    //Brute force
    //TC - O(1)
    //SC - O(1)
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            if(num>=1000){
                sb.append('M');
                num -= 1000;
            } if(num>=900 && num<1000){
                sb.append("CM");
                num -= 900;
            } if(num>=500 && num<900){
                sb.append('D');
                num -= 500;
            } if(num>=400 && num<500){
                sb.append("CD");
                num -= 400;
            }if(num>=100 && num<400){
                sb.append('C');
                num -= 100;
            } if(num>=90 && num<100){
                sb.append("XC");
                num -= 90;
            }if(num>=50 && num<90){
                sb.append('L');
                num -= 50;
            } if(num>=40 && num<50){
                sb.append("XL");
                num -= 40;
            } if(num>=10 && num<40){
                sb.append('X');
                num -= 10;
            } if(num==9){
                sb.append("IX");
                num -= 9;
            } if(num>=5 && num<9){
                sb.append('V');
                num -= 5;
            } if(num==4){
                sb.append("IV");
                num -= 4;
            } if(num>=1 && num<4){
                sb.append('I');
                num -= 1;
            }
        }
        return sb.toString();
    }

    //No use
    public static char getChar(int i){
        return switch (i) {
            case 1 -> 'I';
            case 5 -> 'V';
            case 10 -> 'X';
            case 50 -> 'C';
            case 100 -> 'L';
            case 500 -> 'D';
            case 1000 -> 'M';
            default -> 0;
        };
    }
    public static String getStr(int i){
        return switch (i) {
            case 4 -> "IV";
            case 9 -> "IX";
            case 40 -> "XL";
            case 90 -> "XC";
            case 400 -> "CD";
            case 900 -> "CM";
            default -> "";
        };
    }
}
