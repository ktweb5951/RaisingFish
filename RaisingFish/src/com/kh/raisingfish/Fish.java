package com.kh.raisingfish;

import java.util.Scanner;

public class Fish {
    private String name;
    private String grade;
    private int rating;
    private int hunger;
    private String status;



    public Fish() {
            
    }
    
    public Fish(String name, String grade, int rating) {
        this.name = name;
        this.grade = grade;
        this.rating = rating;
        this.hunger = 40;
        this.status = "정상";
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
    public int getRating() {
    	return rating;
    }
    
    public int getHunger() {
        return hunger;
    }

    public String getStatus() {
        return status;
    }
    
	public void setHunger(int hunger) {
		this.hunger = hunger;
		
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

    
        
   

    public void increaseHunger(String foodType) {
        int hungerIncrease = 0;
        
        if (foodType.equals("갯지렁이")) {
            hungerIncrease = 5;
        } else if (foodType.equals("작은생선")) {
            hungerIncrease = 10;
        } else if (foodType.equals("큰생선")) {
            hungerIncrease = 15;
        }
        
        hunger += hungerIncrease;

        if (hunger >= 100) {
            status = "진화가능";
            evolve();
        } else if (hunger >= 80) {
            status = "배부름";
        } else if (hunger >= 40) {
            status = "정상";
        } else if (hunger >= 20) {
            status = "보통";
        } else if (hunger >= 10) {
            status = "배고픔";
        } else if (hunger < 5) {
            status = "위기";
        }
    }

    public void evolve() {
        Scanner sc = new Scanner(System.in);
        if (hunger == 100) {
            System.out.println("진화가 가능합니다. 원하는 물고기로 진화할 수 있습니다.");
            if (rating == 1) {
                System.out.println("진화하고 싶은 물고기를 선택하세요.");
                System.out.println("1. 광어");
                System.out.println("2. 우럭");
                
                int choice = sc.nextInt();
                sc.nextLine(); // consume the newline character
                
                if (choice == 1) {
                    grade = "광어";
                    rating = 2;
                    System.out.println("광어로 진화했습니다.");
                } else if (choice == 2) {
                    grade = "우럭";
                    rating = 2;
                    System.out.println("우럭으로 진화했습니다.");
                } else {
                    System.out.println("잘못된 선택입니다.");
                }
            } else if (rating == 2) {
                System.out.println("진화하고 싶은 물고기를 선택하세요.");
                System.out.println("1. 연어");
                System.out.println("2. 참치");
                
                int choice = sc.nextInt();
                sc.nextLine(); // consume the newline character
                
                if (choice == 1) {
                    grade = "연어";
                    rating = 3;
                    System.out.println("연어로 진화했습니다.");
                } else if (choice == 2) {
                    grade = "참치";
                    rating = 3;
                    System.out.println("참치로 진화했습니다.");
                } else {
                    System.out.println("잘못된 선택입니다.");
                }
            } else if (rating == 3) {
                System.out.println("진화하고 싶은 물고기를 선택하세요.");
                System.out.println("1. 상어");
                System.out.println("2. 돌고래");
                
                int choice = sc.nextInt();
                sc.nextLine(); // consume the newline character
                
                if (choice == 1) {
                    grade = "상어";
                    rating = 4;
                    System.out.println("상어로 진화했습니다.");
                } else if (choice == 2) {
                    grade = "돌고래";
                    rating = 4;
                    System.out.println("돌고래로 진화했습니다.");
                } else {
                    System.out.println("잘못된 선택입니다.");
                }
            } else if (rating == 4) {
                System.out.println("진화하고 싶은 물고기를 선택하세요.");
                System.out.println("1. 범고래");
                System.out.println("2. 향유고래");
                
                int choice = sc.nextInt();
                sc.nextLine(); // consume the newline character
                
                if (choice == 1) {
                    grade = "범고래";
                    rating = 5;
                    System.out.println("범고래로 진화했습니다.");
                } else if (choice == 2) {
                    grade = "함유고래";
                    rating = 5;
                    System.out.println("향유고래로 진화했습니다.");
                } else {
                    System.out.println("잘못된 선택입니다.");
                }
            } else {
                System.out.println("더 이상 진화할 수 있는 등급이 없습니다.");
            }
        }
    }

    public void evolve(String selectedFish) {
        switch (selectedFish) {
            case "광어":
                grade = "광어";
                rating = 2;
                break;
            case "우럭":
                grade = "우럭";
                rating = 2;
                break;
            case "연어":
                grade = "연어";
                rating = 3;
                break;
            case "참치":
                grade = "참치";
                rating = 3;
                break;
            case "상어":
                grade = "상어";
                rating = 4;
                break;
            case "돌고래":
                grade = "돌고래";
                rating = 4;
                break;
            case "범고래":
                grade = "범고래";
                rating = 5;
                break;
            case "향유고래":
                grade = "향유고래";
                rating = 5;
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                break;
        }
    }

    public void decreaseHunger(int amount) {
        hunger -= amount;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void gameOver() {
        if (hunger == 0) {
            System.out.println("게임 오버! 물고기가 배고파서 죽었습니다.");
            System.exit(0);
        }
    }
    

}
