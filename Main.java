

//package meanmail.stepic.java.tests.module5.lesson2.step9;

        import java.io.ByteArrayInputStream;
        import java.io.ByteArrayOutputStream;
        import java.io.IOException;
        import java.io.PrintStream;

        import static java.lang.System.exit;

//       import static meanmail.stepic.java.tests.Assertions.assertEquals;

/**
 * Created by meanmail on 13.10.2016.
 * <p>
 * Этот класс переименуйте в Main
 */
public class Main {


    public static void main(String[] args) throws IOException {

        // Код для тестирования. Перед отправкой в степик, удалите или закомиентируйте код для тестирования
        test();
        if (!testing)
            return;
        // Конец кода который не нужно отправлять в стэпик
        int buf = 0;
        int a = 0;
        boolean flag = false;
        int count=0;
           while (true) {

                try {
                    a = System.in.read ();

                } catch (IOException e) {
                    e.printStackTrace ();
                }
                if (a == 13) {
                    if (buf==13)
                        System.out.write (buf);
                    buf = a;
                }
                if (a == 10 && buf != 13) {
                    if (flag == false&count !=0) {
                        System.out.write (buf);
                        System.out.write (a);
                    } else {
                        flag = true;
                        System.out.write (a);
                    }
                }
                if (a == 10 && buf == 13) {
                    System.out.write (a);
                    buf = 0;
                    flag = true;
                }
                if (a != 13 & a != 10 & a != -1) {
                    System.out.write (a);
                    flag = false;
                }
                if (a == -1 & buf == 13) {
                    System.out.write (buf);
                    buf = 0;
                    break;
                }
                if (a == -1 & buf != 13) {
                    break;
                }
            }

        count++;
        System.out.flush();
        }

//    }
        // Здесь поместите ваш код, запустите и код будет протестирован



    // Нижележащий код для тестирования, не изменяйте его

    private static boolean testing = false;
    private static ByteArrayOutputStream outStream;
    private static final PrintStream standartOut = System.out;

    private static byte[][][] testSet = new byte[][][]{{{65, 13, 10, 10, 13}, {65, 10, 10, 13}}, {{}, {}}, {{13, 10}, {10}},
            {{10, 13}, {10, 13}}, {{13, 13, 13, 13, 13},{13, 13, 13, 13, 13}}, {{10, 10}, {10, 10}}, {{13, 13, 10}, {13, 10}},{ {10, 13, 5, 13}, {10, 13, 5, 13}}};

    private static void test() throws IOException {

        if (testing)
            return;

        testing = true;

        for (int i = 0; i < testSet.length; i++) {

            testStart(i);

            main(null);

            testEnd(i);
            System.out.println (" ");
        }

        testing = false;
    }

    // Этот метод для тестирования.
    private static void testStart(int i) throws IOException {

        ByteArrayInputStream tsStream = new ByteArrayInputStream(testSet[i][0]);

        // Пересылаем тестовый набор в выходной поток
        System.setIn(tsStream);
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    private static void testEnd(int i) {

        System.setOut(standartOut);

        byte[] result = outStream.toByteArray();
       for (int r=0; r<result.length;r++)
           System.out.print (result[r]+" " );
        assertEquals(result, testSet[i][1], "Test #" + (i + 1));
    }

    private static void assertEquals(byte[] result, byte[] bytes, String s) {
        if (result==bytes)
            System.out.println ("juf");
        else System.out.println ("ytf");
    }

}