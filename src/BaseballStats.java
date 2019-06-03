import java.util.Scanner;

    public class BaseballStats
    {
        public static void main(String[] args){
            intro();
            handleOnePlayer();
        }

        // get input for one player
        public static void handleOnePlayer(){
            Scanner key = new Scanner(System.in);
            int sing = getNumber(key, "singles");
            int doub = getNumber(key, "doubles");
            int triples = getNumber(key, "triples");
            int hrs = getNumber(key, "home runs");
            int walks = getNumber(key, "walks");
            int IBB = getNumber(key, "Intentional Walks");
            int hbp = getNumber(key,"hit by pitches");
            int sf = getNumber(key, "sacrifice flies");
            int K = getNumber(key, "strike outs");
            int abs = getNumber(key, "at bats");
            System.out.println();
            calculateResult(sing, doub, triples, hrs, walks, IBB, hbp, sf, K, abs);
        }

        // show intro to program
        public static void intro(){
            System.out.println("A program that calculates simple baseball statistics.");
            System.out.println("Input is numbers of singles, doubles, triples, home runs,");
            System.out.println("at bats, walks, hit by pitches, and sacrifice flies.");
            System.out.println("Program calculates and displays hits, batting average,wOBA,");
            System.out.println("slugging percentage, BAbip, Runs Created, and on base percentage.");
            System.out.println();
        }

        public static void calculateResult(int sing, int doub, int triples,
                                           int hrs, int walks, int IBB, int hbp, int sf, int K, int abs){
            int hits = sing + doub + triples + hrs;
            double avg = (1.0 * hits) / abs;
            double uBB = (walks - IBB);
            double wOBA = (((0.69*uBB) + (0.72*hbp) + (0.87*sing)
                        + (1.22*doub) + (1.54*triples) + (1.97*hrs))
                        /(abs+walks-IBB+sf+hbp));
            double TB = (sing + doub * 2.0 + triples * 3.0 + hrs * 4.0);
            double slg = (sing + doub * 2.0 + triples * 3.0 + hrs * 4.0) / abs;
            double OBP = (1.0 * hits + walks + hbp) / (abs + walks + hbp + sf);
            double BAbip = ((1.0 * hits) - hrs)/(abs-K-hrs+sf);
            double basicRC = ((1.0*hits + walks) * TB)/(abs + walks);

            displayResults(hits, avg, wOBA, TB, slg, OBP, BAbip, basicRC);
        }

        public static void displayResults(int hits, double ave, double wOBA, double TB, double slug, double onBase, double BAbip, double basicRC){
            sop("hits: " + hits);
            sop("batting average: " + round3(ave));
            sop("wOBA: " +round3(wOBA));
            sop("Total Bases: " +TB);
            sop("slugging %: " + round3(slug));
            sop("On base %: " + round3(onBase));
            sop("BAbip %: " + round3(BAbip));
            sop("Runs Created Estimate %: " + round3(basicRC));
        }

        public static double round3(double val){
            return (double)(Math.round(1000 * val)) / 1000;
        }

        public static void sop(String s){
            System.out.println(s);
        }

        public static int getNumber(Scanner key, String what){
            System.out.print("Please enter the number of " + what + ": ");
            int input = key.nextInt();
            return input;
        }
    }
