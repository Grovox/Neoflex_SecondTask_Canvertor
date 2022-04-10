package SecondTask;

public class Convector {
    private String binary,decimal,hexadecimal;
    private static String pastBinary,pastDecimal,pastHexadecimal;
    private String labelSystems;
    private String convertNumber = null;
    Convector(String binary,String decimal,String hexadecimal){
        this.binary = binary;
        this.decimal = decimal;
        this.hexadecimal = hexadecimal;
    }

    private String removeLeadingZeroes(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    boolean valuesTest(){
        try {
            boolean presenceError = false;
            int qtyEmpty = 0;

            binary = removeLeadingZeroes(binary);
            decimal = removeLeadingZeroes(decimal);
            hexadecimal = removeLeadingZeroes(hexadecimal);

            if(binary.equals(pastBinary) || binary.equals("error")) {
                binary = "";
            }

            if(decimal.equals(pastDecimal) || decimal.equals("error")) {
                decimal = "";
            }

            if(hexadecimal.equals(pastHexadecimal) || hexadecimal.equals("error")) {
                hexadecimal = "";
            }

            if (binary.length() <= 14 && decimal.length() <= 5 && hexadecimal.length() <= 4) {

                if (binary.length() == 0) {
                    qtyEmpty++;
                } else labelSystems = "binary";

                if (decimal.length() == 0) {
                    qtyEmpty++;
                } else labelSystems = "decimal";

                if (hexadecimal.length() == 0) {
                    qtyEmpty++;
                } else labelSystems = "hexadecimal";

                if (qtyEmpty == 2) {
                    if (labelSystems == "binary" && binary.matches("[01]+"))
                        presenceError = true;
                    if (labelSystems == "decimal" && decimal.matches("[0-9]+"))
                        presenceError = true;
                    if (labelSystems == "hexadecimal" && hexadecimal.matches("[0-9A-Fa-f]+"))
                        presenceError = true;
                }
            }
            return presenceError;
        }catch (Exception e){
            System.err.println(e);
            return false;
        }

    }

    String binaryConvector(){
        try {

            if (labelSystems == "binary")
                convertNumber = binary;

            if (labelSystems == "decimal")
                convertNumber = Integer.toBinaryString(Integer.parseInt(decimal, 10));

            if (labelSystems == "hexadecimal")
                convertNumber = Integer.toBinaryString(Integer.parseInt(hexadecimal, 16));

            pastBinary = convertNumber;
            if (Integer.parseInt(convertNumber, 2) > 10000) {
                convertNumber = "error";
            }
            return convertNumber;
        }catch (Exception e){
            System.err.println(e);
            convertNumber = null;
            return "Error";
        }
    }

    String decimalConvector(){
        try {
            if (labelSystems == "binary") {
                convertNumber = Integer.toString(Integer.parseInt(binary, 2));
            }
            if (labelSystems == "decimal")
                convertNumber = decimal;

            if (labelSystems == "hexadecimal") {
                convertNumber = Integer.toString(Integer.parseInt(hexadecimal, 16));
            }
            pastDecimal = convertNumber;
            if (Integer.parseInt(convertNumber, 10) > 10000) {
                convertNumber = "error";
            }
            return convertNumber;
        }catch (Exception e) {
            convertNumber = null;
            System.err.println(e);
            return "Error";
        }
    }

    String hexadecimalConvector(){
        try {
            if (labelSystems == "binary") {
                convertNumber = Integer.toHexString(Integer.parseInt(binary, 2));
            }
            if (labelSystems == "decimal") {
                convertNumber = Integer.toHexString(Integer.parseInt(decimal, 10));
            }
            if (labelSystems == "hexadecimal") {
                convertNumber = hexadecimal;
            }

            convertNumber = convertNumber.toUpperCase();

            pastHexadecimal = convertNumber;
            if (Integer.parseInt(convertNumber, 16) > 10000) {
                convertNumber = "error";
            }
            return convertNumber;
        }catch (Exception e) {
            System.err.println(e);
            return "Error";
        }
    }

}
