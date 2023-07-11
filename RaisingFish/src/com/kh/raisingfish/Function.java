package com.kh.raisingfish;

import java.util.Random;
import java.util.Scanner;

public class Function {
    private int money;
    private int[] foodArrs;
    private String[] foodType;
    private boolean fishCreated;
    private Fish fish;
    private Food food1;
    private Food food2;
    private Food food3;

    public Function() {
        this.money = 500;
        this.foodArrs = new int[]{0, 0, 0};
        this.foodType =  new String[]{"갯지렁이", "작은생선", "큰생선"};
        this.fishCreated = false;
        this.food1 = new Food("갯지렁이", 500, 5, 1);
        this.food2 = new Food("작은생선", 1000, 10, 2);
        this.food3 = new Food("큰생선", 1500, 15, 3);
    }
    
    public void startGame() {
        Scanner sc = new Scanner(System.in);
        int choice;

       intro();
       finish:
        while (true) {
            printMenu();

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 0:
                    printGameDescription();
                    break;
                case 1:
                    createFish(sc);
                    break;
                case 2:
                    printFishInfo();
                    break;
                case 3:
                    playGame(sc);
                    break;
                case 4:
                    printFishCatalog();
                    break;
                case 5:
                    System.out.println("게임을 종료합니다. 이용해주셔서 감사합니다!");
                    break finish; 
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }
        }
    }

    public void intro() {
 		System.out.println("┌──────────────────────────────────────────┐");
 		System.out.println("│   __ _     _                             │");
 		System.out.println("│  / _(_)___| |__                물        │");
 		System.out.println("│ | |_| / __| '_ \\               고        │");
 		System.out.println("│ |  _| \\__ \\ | | |              기        │");
 		System.out.println("│ |_| |_|___/_| |_|                        │" );
 		System.out.println("│       .                                  │");
 		System.out.println("│      \":\"                       키        │");
 		System.out.println("│    ___:____     |\"\\/\"|         우        │");
 		System.out.println("│  ,'        `.    \\  /          기        │");
 		System.out.println("│  |  O        \\___/  |                    │");               
 		System.out.println("│~^~^~^~^~^~^~^~^~^~^~^~^~                 │");
 		System.out.println("└──────────────────────────────────────────┘");
 		System.out.println("┌──────────────────────────────────────────────┐");
 		System.out.println("│※ 물고기 키우기 게임에 오신 것을 환영합니다. ※│");
 		System.out.println("└──────────────────────────────────────────────┘");
 	}

 	public void printMenu() {
 		System.out.println("┌─────────────────────────────────────────────┐");
 		System.out.println("│ 0. 게임 설명                                │");
 		System.out.println("│ 1. 내 물고기 생성                           │");
 		System.out.println("│ 2. 내 물고기 정보                           │");
 		System.out.println("│ 3. 게임 시작                                │");
 		System.out.println("│ 4. 도감                                     │");
 		System.out.println("│ 5. 게임 종료                                │");
 		System.out.println("└─────────────────────────────────────────────┘");
 		System.out.print("선택 >> ");
     }

     public void printGameDescription() {
     	System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────┐");
         System.out.println("│ O<  게임 설명 >O                                                                      │");
         System.out.println("│물고기를 키우는 게임입니다.                                                            │");
         System.out.println("│게임의 목표는 최종 등급까지 진화하는것이 목표입니다.                                   │");
         System.out.println("│물고기를 선택하여 이름을 지어주면 게임을 플레이 할 수 있습니다.                        │");
         System.out.println("│물고기의 포만감을 100으로 만들면 다음 등급으로 진화 할 수 있습니다.                    │");
         System.out.println("│물고기의 포만감에 따라 물고기 상태가 변합니다.                                         │");
         System.out.println("│물고기 포만감이 0이되면 물고기는 죽게되어 게임오버가 됩니다.                           │");
         System.out.println("│포만감은 모험, 돈벌기 미니게임을 하면 5씩 소진됩니다.                                  │");
         System.out.println("│물고기의 포만감을 유지하거나 올릴려면 먹이를 계속 공급해줘야합니다.                    │");
         System.out.println("│먹이는 소지금으로 구매하거나 모험을 통해 획득 할 수 있습니다.                          │");
         System.out.println("│돈은 미니게임을 통해 벌 수 있습니다.                                                   │");
         System.out.println("└───────────────────────────────────────────────────────────────────────────────────────┘");
     }
 //캐릭터 생성
    public void createFish(Scanner sc) {
	   System.out.println("\n[물고기 생성]");
       if (fishCreated) {
       	System.out.println("이미 물고기가 생성되었습니다.");
       	return;
       }
       System.out.print("물고기 이름 : ");
       String name = sc.nextLine();
       
       System.out.println("물고기 선택 :");
       System.out.println("1. 구피");
       System.out.println("2. 금붕어");
       System.out.println("3. 송사리");
       System.out.print("선택 >> ");
       int fishType = sc.nextInt();

       switch (fishType) {
           case 1:
               fish = new Fish(name, "구피", 1);
               break;
           case 2:
               fish = new Fish(name, "금붕어", 1);
               break;
           case 3:
               fish = new Fish(name, "송사리", 1);
               break;
           default:
               System.out.println("잘못된 입력입니다. 캐릭터 생성을 취소합니다.");
               return;
       }
       fishCreated = true;
       System.out.println("\n물고기가 생성되었습니다!");
    }
    
 //정보 조회
    public void printFishInfo() {
        if (fish == null) {
            System.out.println("\n[정보 조회]");
            System.out.println("물고기가 생성되지 않았습니다.");
            return;
        }
        
        String status;
        if (fish.getHunger() >= 80) {
            status = "배부름";
        } else if (fish.getHunger() >= 40) {
            status = "정상";
        } else if (fish.getHunger() >= 20) {
            status = "보통";
        } else if (fish.getHunger() >= 10) {
            status = "배고픔";
        } else {
            status = "위기";
        }
        
    	System.out.println("┌");
        System.out.println("│[정보 조회]");
        System.out.println("│이름   : " + fish.getName());
        System.out.println("│등급   : " + "[등급"+ fish.getRating()+ "] " +fish.getGrade() );
        System.out.println("│포만감 : " + fish.getHunger());
        System.out.println("│상태   : " + fish.getStatus());
        System.out.println("│소지금 : " + money +"골드" );
        System.out.println("│먹이   : " );
        System.out.print("│");
        for(int i=0; i<foodArrs.length; i++) {
        	System.out.print(" [" + foodType[i]+ ": " + foodArrs[i]  + "] ");
        }
        System.out.println("\n└");
        System.out.println();
    }

    
 //게임 시작 메뉴
    public void playGame(Scanner sc) {
        if (fish == null) {
            System.out.println("\n[게임 시작]");
            System.out.println("물고기가 생성되지 않았습니다.");
            return;
        }

        end :
        while(true) {
        	System.out.println("\n[게임 시작]");
        	System.out.println("1. 먹이 주기");
        	System.out.println("2. 먹이 구매");
        	System.out.println("3. 돈 벌기");
        	System.out.println("4. 모험");
        	System.out.println("5. 진화");
        	System.out.println("6. 정보 보기");
        	System.out.println("7. 메뉴로 돌아가기");
        	System.out.print("선택 >>");
        	int choice = sc.nextInt();
        	switch (choice) {
        	case 1:
        		feedFish(sc);
        		break;
        	case 2:
        		buyFood(sc);
        		break;
        	case 3:
        		earnMoney(sc);
        		break;
        	case 4:
        		goAdventure();
        		break;
        	case 5:
        		evolveFish();
        		break;
        	case 6:
        		printFishInfo();
        		break;
        	case 7:
        		break end;
        	default:
        		System.out.println("잘못된 입력입니다.");
        		break end;
        	}        	
        }
    }
    
//먹이주기
    public void feedFish(Scanner sc) {
        if (fish.getHunger() >= 100) {
            System.out.println("물고기의 포만감이 가득차있습니다.");
            return;
        }
        
        System.out.println("보유중인 먹이");
        for(int i = 0; i < foodArrs.length; i++) {
            System.out.println((i + 1) + ". [등급 " + (i + 1) + "] " + foodType[i] + ": " + foodArrs[i] + "개");
        }
        System.out.println();
        
        System.out.print("물고기에게 먹일 먹이를 선택해 주세요: ");
        int choiceFood = sc.nextInt();
        
        if (choiceFood < 1 || choiceFood > foodArrs.length) {
            System.out.println("잘못된 선택입니다.");
            return;
        }
        
        int foodIndex = choiceFood - 1;
        Food selectedFood = getSelectedFood(foodIndex);
        
        if (fish.getRating() >= selectedFood.getRating()) {
            if (foodArrs[foodIndex] != 0) {
                System.out.println(fish.getName() + "이 " + selectedFood.getFoodName() + "를 먹었습니다. 포만감이 " + selectedFood.getHunger() + " 증가했습니다.");
                fish.increaseHunger(selectedFood.getFoodName());
                foodArrs[foodIndex]--;
            } else {
                System.out.println("먹이가 부족합니다.");
            }
        } else {
            System.out.println("먹이의 등급이 높아 먹을 수 없습니다.");
        }
    }

 //먹이구매
    public void buyFood(Scanner sc) {
    	  System.out.println("먹이를 선택하세요:");
          System.out.println("1. [등급 " + food1.getRating() + "] " + food1.getFoodName() + " " + food1.getPrice() + "골드" + "(포만감 : 5)" );
          System.out.println("2. [등급 " + food2.getRating() + "] " + food2.getFoodName() + " " + food2.getPrice() + "골드" + "(포만감 : 10)");
          System.out.println("3. [등급 " + food3.getRating() + "] " + food3.getFoodName() + " " + food3.getPrice() + "골드" + "(포만감 : 15)");
          System.out.print("선택: ");
          int typeFood = sc.nextInt();

          if (typeFood < 1 || typeFood > 3) {
              System.out.println("잘못된 선택입니다.");
              return;
          }

          System.out.print("구매할 먹이 갯수 입력: ");
          int amount = sc.nextInt();

          Food selectedFood;
          int totalCost;

          switch (typeFood) {
              case 1:
                  selectedFood = food1;
                  totalCost = amount * food1.getPrice();
                  break;
              case 2:
                  selectedFood = food2;
                  totalCost = amount * food2.getPrice();
                  break;
              case 3:
                  selectedFood = food3;
                  totalCost = amount * food3.getPrice();
                  break;
              default:
                  System.out.println("잘못된 선택입니다.");
                  return;
          }

          if (money < totalCost) {
              System.out.println("소지금이 부족하여 먹이를 구매할 수 없습니다.");
              return;
          }

          money -= totalCost;
          foodArrs[typeFood - 1] += amount;
          System.out.println(selectedFood.getFoodName() + "을 " + amount + "개 구매하였습니다.");
    }
    
    private Food getSelectedFood(int index) {
        switch (index) {
            case 0:
                return food1;
            case 1:
                return food2;
            case 2:
                return food3;
            default:
                return null;
        }
    }

 //미니게임
    public void earnMoney(Scanner sc) {
    	System.out.println("[돈벌기 미니게임 승리 시 1000골드, 한판당 포만감 5 소진] ");
        System.out.println("[가위바위보 게임]");

        System.out.println("가위바위보 중 하나를 선택하세요.");
        System.out.println("1. 가위");
        System.out.println("2. 바위");
        System.out.println("3. 보");
        System.out.print("선택 >> ");
        int userChoice = sc.nextInt();

        String userMove;
        switch (userChoice) {
            case 1:
                userMove = "가위";
                break;
            case 2:
                userMove = "바위";
                break;
            case 3:
                userMove = "보";
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }

        Random random = new Random();
        int computerChoice = random.nextInt(3) + 1;
        String computerMove;
        switch (computerChoice) {
            case 1:
                computerMove = "가위";
                break;
            case 2:
                computerMove = "바위";
                break;
            case 3:
                computerMove = "보";
                break;
            default:
                computerMove = "알 수 없음";
                break;
        }

        System.out.println("사용자: " + userMove);
        System.out.println("컴퓨터: " + computerMove);

        int result = (userChoice - computerChoice + 3) % 3;
        if (result == 0) {
            System.out.println("무승부입니다.");
        } else if (result == 1) {
            System.out.println("사용자가 이겼습니다! 1000골드를 획득하였습니다.");
            money += 1000;
        } else if (result == 2) {
            System.out.println("컴퓨터가 이겼습니다.");
        }

        fish.decreaseHunger(5);
        System.out.println("포만감이 5 감소하였습니다. 현재 포만감: " + fish.getHunger());
        fish.gameOver();
    }

 //모험
    public void goAdventure() {
        int adventureTime;
	    switch (fish.getRating()) {
	        case 1:
	            adventureTime = 6;
	            break;
	        case 2:
	            adventureTime = 4;
	            break;
	        case 3:
	            adventureTime = 2;
	            break;
	        case 4:
	            adventureTime = 0;
	            break;
	        case 5:
	        	adventureTime = 0;
	        	break;
	        default:
	            System.out.println("잘못된 등급입니다.");
	            return;
	    }

	    System.out.println("포만감 5을 사용하여 모험을 시작합니다." + adventureTime + "초 후 결과가 출력됩니다.");
	    for (int i = adventureTime; i >= 1; i--) {
	        System.out.println("모험 중... " + i + "초");
	        try {
	            Thread.sleep(1000); // 1초 대기
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    Random random = new Random();
	    int resultIndex = random.nextInt(8); 
	    String[] adventureResults = {
	        "500골드", "1000골드", "3000골드", "꽝", "바다쓰레기(꽝)", "작은생선", "갯지렁이", "큰생선"
	    };
	    String result = adventureResults[resultIndex];

	    System.out.println("모험 결과: " + result);

	    switch (result) {
	        case "갯지렁이":
	            foodArrs[0]++;
	            break;
	        case "작은생선":
	            foodArrs[1]++;
	            break;
	        case "큰생선":
	            foodArrs[2]++;
	            break;
	        case "500골드" :
	        	money += 500;
	        	break;
	        case "1000골드" :
	        	money += 1000;
	        	break;	
	        case "3000골드" :
	        	System.out.println("축하합니다!");
	        	money += 3000;
	        	break;	
	        
	    }
	    
	    fish.decreaseHunger(5);
	    System.out.println("현재 포만감: " + fish.getHunger());
	    fish.gameOver();
    }

 //진화
    public void evolveFish() {
        if (fish.getHunger() < 100) {
            System.out.println("진화하기 위해서는 먼저 포만감을 100으로 채워야 합니다.");
            return;
        }

        int currentRating = fish.getRating();
        String[] fishOptions;
        switch (currentRating) {
            case 1:
                fishOptions = new String[]{"광어", "우럭"};
                break;
            case 2:
                fishOptions = new String[]{"연어", "참치"};
                break;
            case 3:
                fishOptions = new String[]{"상어", "돌고래"};
                break;
            case 4:
                fishOptions = new String[]{"범고래", "향유고래"};
                break;
            default:
                System.out.println("더 이상 진화할 수 있는 등급이 없습니다.");
                return;
        }

        System.out.println("진화하고 싶은 물고기를 선택하세요.");
        for (int i = 0; i < fishOptions.length; i++) {
            System.out.println((i + 1) + ". " + fishOptions[i]);
        }
        System.out.print("선택 >>");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine(); 

        if (choice < 1 || choice > fishOptions.length) {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        String selectedFish = fishOptions[choice - 1];
        fish.evolve(selectedFish);
        fish.setHunger(20);
        fish.setStatus("정상");

        System.out.println(fish.getName() + "이(가) " + selectedFish + "(으)로 진화했습니다!");
    }

    public void printFishCatalog() {
        System.out.println("\n[도감]");
        System.out.println("등급 1: 구피, 금붕어, 송사리");
        System.out.println("등급 2: 광어, 우럭");
        System.out.println("등급 3: 연어, 참치");
        System.out.println("등급 4: 상어, 돌고래");
        System.out.println("등급 5: 범고래, 향유고래");
    }


}

