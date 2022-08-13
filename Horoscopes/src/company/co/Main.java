package company.co;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

///import static server.Client.day;
//import static server.Client.month;

class Server {

    static String sign;

    public static void main(String[] args) throws IOException {
        //Define the Socket
        ServerSocket doorsocket = new ServerSocket(7489);

        while (true) {
            //Accept Connection from Client
            Socket connectionsocket = doorsocket.accept();
            System.out.println("Connected");

            //Defing the InputStream on Socket
            InputStreamReader ISR = new InputStreamReader(connectionsocket.getInputStream());
            BufferedReader infromclient = new BufferedReader(ISR);

            //Reading the Sentence From Client
            String sentence;
            sentence = infromclient.readLine();

            String day2 = sentence.substring(0, 2);
            String month2 = sentence.substring(2, 4);

            int day = Integer.parseInt(day2);
            int month = Integer.parseInt(month2);
            //Defing OutPutStream on Socket
            DataOutputStream OutToClient = new DataOutputStream(connectionsocket.getOutputStream());

            if (month == 1) {

                if (day < 20) {
                    sign = "Capricorn";
                } else if (day >= 20 && day <= 31) {
                    sign = "Aquarius";
                }
            } else if (month == 2) {
                if (day < 19) {
                    sign = "Aquarius";
                } else if (day >= 19 && day <= 29) {
                    sign = "Pisces";
                }
            } else if (month == 3) {
                if (day < 21) {
                    sign = "Pisces";
                } else if (day >= 21 && day <= 31) {
                    sign = "Aries";
                }
            } else if (month == 4) {
                if (day < 20) {
                    sign = "Aries";
                } else if (day >= 20 && day <= 30) {
                    sign = "Taurus";
                }
            } else if (month == 5) {
                if (day < 21) {
                    sign = "Taurus";
                } else if (day >= 21 && day <= 31) {
                    sign = "Gemini";
                }
            } else if (month == 6) {
                if (day < 21) {
                    sign = "Gemini";
                } else if (day >= 21 && day <= 30) {
                    sign = "Cancer";
                }
            } else if (month == 7) {
                if (day < 23) {
                    sign = "Cancer";
                } else if (day >= 21 && day <= 31) {
                    sign = "Leo";
                }
            } else if (month == 8) {
                if (day < 23) {
                    sign = "Leo";
                } else if (day >= 23 && day <= 31) {
                    sign = "Virgo";
                }
            } else if (month == 9) {
                if (day < 23) {
                    sign = "Virgo";
                } else if (day >= 23 && day <= 30) {
                    sign = "Libra";
                }
            } else if (month == 10) {
                if (day < 23) {
                    sign = "Libra";
                } else if (day >= 23 && day <= 31) {
                    sign = "Scorpio";
                }
            } else if (month == 11) {
                if (day < 22) {
                    sign = "scorpio";
                } else if (day >= 22 && day <= 30) {
                    sign = "Sagittarius";
                }
            } else if (month == 12) {
                if (day < 22) {
                    sign = "Sagittarius";
                } else if (day >= 22 && day <= 31) {
                    sign = "Capricorn";
                }
            } else {

                sign = "EXIT FROM SERVER";

            }



            OutToClient.writeBytes( sign + "\n");
            OutToClient.close();
            connectionsocket.close();

        }
    }

}