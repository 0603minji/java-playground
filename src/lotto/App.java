package lotto;

import java.util.*;

public class App {
    static Scanner sc = new Scanner(System.in);
    static int[] lotto = new int[6];
    static boolean keepTrue = true;

    public static void main(String[] args) {
        while (keepTrue) {
            menuSelect();

            int menu;
            menu = Integer.parseInt(sc.nextLine());

            switch (menu) {
                case 1:
                    TicketingMyself();
                    break;
                case 2:
                    TicketingAuto();
                    break;
                case 3:
                    checkMyLotto();
                    break;
                case 4:
                    exit();
                    break;
            }
        }
    } // main 함수 종료

    // 종료 함수 ------------------------------------------------
    private static void exit() {
        clearConsole();
        System.out.print("종료하시겠습니까? (Y/N) > ");
        if (sc.nextLine().equals("Y")) {
            System.out.println("Bye ~~");
            keepTrue = false;
        }
    }

    // 번호 조회 -----------------------------------------------------
    private static void checkMyLotto() {
        clearConsole();
        System.out.print("[ 발권 번호 조회 ]\n");
        printLotto(lotto, " ");
        
        System.out.println("\n====================================");
        System.out.println("상위메뉴로 가려면 아무키나 누르세요.");
        sc.nextLine();
    }

    // 메뉴 선택 화면 ----------------------------------------------
    private static void menuSelect() {
        clearConsole();

        System.out.println("""
                [ 로또 복권 프로그램 ]

                1. 수동 발권
                2. 자동 발권
                3. 발권번호 조회
                4. 종료
                =============================
                메뉴 입력 > """);
    }

    // 수동 발권 ----------------------------------------------
    static void TicketingMyself() {
        clearConsole();

        while (true) {
            System.out.print("""
                    [ 수동 발권 ]
                    1~45 숫자 범위에서 원하는 번호를
                    스페이스 구분자로 6개 입력하세요.
                    숫자는 정렬되어 있지 않아도 상관없다.
                    ==================================
                    번호 > """);

            String str = sc.nextLine();
            String[] inputNums = str.split(" ");

            lotto[0] = Integer.parseInt(inputNums[0]);
            lotto[1] = Integer.parseInt(inputNums[1]);
            lotto[2] = Integer.parseInt(inputNums[2]);
            lotto[3] = Integer.parseInt(inputNums[3]);
            lotto[4] = Integer.parseInt(inputNums[4]);
            lotto[5] = Integer.parseInt(inputNums[5]);

            printLotto(lotto, " ");

            System.out.print("\n위의 번호가 맞나요? (Y/N) > ");
            String yesNo = sc.nextLine();
            if (yesNo.equals("Y"))
                break;
        }
    }

    // 자동 발권 ----------------------------------------------
    private static void TicketingAuto() {
        clearConsole();

        System.out.print("""
                [ 자동 발권 ]

                 자동 발권 번호 > """);

        getRandomNum();
        orderingLotto(lotto);
        printLotto(lotto, " ");

        System.out.println("\n====================================");
        System.out.println("상위메뉴로 가려면 아무키나 누르세요.");
        sc.nextLine();
    }

    // 난수 (랜덤) 생성 함수 ----------------------------------------------
    private static void getRandomNum() {
        int i, j;
        Random random = new Random();

        for (i = 0; i < 6; i++) {
            while (true) {
                int randomNum = random.nextInt(45) + 1;
                for (j = 0; j < 6; j++) {
                    if (lotto[j] == randomNum)
                        break;
                }
                if (j == 6) {
                    lotto[i] = randomNum;
                    break;
                }
            }

        }
    }

    // 로또 번호 출력 함수 ----------------------------------------------
    private static void printLotto(int[] arr, String dex) {
        for (int i1 : arr)
            System.out.print(i1 + dex);
    }

    // 로또 번호 정렬 함수 ----------------------------------------------
    private static void orderingLotto(int[] arr) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    // 콘솔창 지우기 함수 ----------------------------------------------
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
