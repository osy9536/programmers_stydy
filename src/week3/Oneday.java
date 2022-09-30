package week3;

import org.jcp.xml.dsig.internal.dom.DOMSubTreeData;

import java.util.Objects;

public class Oneday {
    public static class Public{
        int carNum;
        int oil=100;
        int speed=0;
        int presentPeopleNum=0;


    }
    public static class Bus extends Public{
        int presentSpeed;
        int num;
        int price=1000;
        int maxPeopleNum=30;
        String state="운행";

        public Bus() {//요구사항 1
            num = (int)(Math.random()*100+1);
            System.out.println("버스 번호 : "+num);
        }


        void setPresentPeople(int num){ //승객이 탔을 경우 현재 승객수와 최대승객수를 조정
            if(presentPeopleNum+num<maxPeopleNum){
                this.presentPeopleNum+=num;
                maxPeopleNum-=num;
            }
            else System.out.println("최대 승객 수 초과");
        }


        void rideleftprice(){ //탑승 승객 수 , 잔여 승객 수 , 요금 확인 출력
            System.out.println("탑승 승객 수 = " + presentPeopleNum);
            System.out.println("잔여 승객 수 = " + maxPeopleNum);
            System.out.println("요금 확인 = " + (price*presentPeopleNum));
        }

        void plusMinusOil(int pmoil){ //현재 오일량을 조정
            this.oil+=pmoil;
            if(oil<10){
                state="차고지행";
            }
        }

        void presentOil(){ //현재 오일량 출력
            System.out.println("주유량 = "+ oil);
        }

        void stateChange(){ //stateChange 함수 입력 시 운행 <-> 차고지행 바뀜
            if(state.equals("운행")){
                state="차고지행";
                maxPeopleNum=30;
                this.presentPeopleNum=0;
            }
            else if(state.equals("차고지행")){
                state="운행";
            }
        }

        void stateBus(){ //요구사항 2 버스 상태 변경
            System.out.println("상태 = " + state);
            System.out.println("주유량 = " + oil);
            if(oil<10){
                System.out.println("주유 필요");
            }
        }

        void speedChange(int currentSpeed){
            if(oil<10){
                System.out.println("주유량을 확인해 주세요.");
            }
            else {
                presentSpeed+=currentSpeed;
            }
        }


    }
    public static class Texi extends Public{
        int presentSpeed;
        int num;
        int price=3000;
        int maxPeopleNum=4;
        String station;
        int length;
        String state="일반";

        public Texi() {//요구사항 1
            num = (int)(Math.random()*100+1);
            System.out.println("택시 번호 : "+num);
            System.out.println("주유량 = "+this.oil);
            System.out.println("상태 = "+state);
        }

        void setPresentPeople(int num, String point, int len) {//승객이 탔을경우

            this.presentPeopleNum += num;
            station = point;
            length = len;
            state = "운행중";
            if (len > 1) {
                price = 3000 + (1000 * (len - 1));
            }
        }

        void rideleftprice() { //승객수 출력
            if (presentPeopleNum > 4) {
                System.out.println("최대 승객 수 초과");
                presentPeopleNum=0;
            } else {
                System.out.println("탑승 승객 수 = " + this.presentPeopleNum);
                System.out.println("잔여 승객 수 = " + (maxPeopleNum - this.presentPeopleNum));
                System.out.println("기본 요금 확인 = 3000");
                System.out.println("목적지 = " + station);
                System.out.println("목적지까지 거리 = " + length + "km");
                System.out.println("지불할 요금 = " + (price));
                System.out.println("상태 = " + state);
            }
        }



        void plusMinusOil(int pmoil){ //현재 오일량을 조정
            this.oil+=pmoil;
            if(oil<10){
                state="운행불가";
            }
        }

        void pay(){ //요금 결제
            System.out.println("주유량 = "+ oil);
            if(oil==0){
                System.out.println("상태 = 운행불가");
            }
            System.out.println("누적 요금 = "+ price);
            presentPeopleNum=0;
            if(oil==0){
                System.out.println("주유 필요");
            }

        }



    }

    public static void main(String[] args) {
//        Bus bus1 = new Bus();
//        Bus bus2 = new Bus();  //버스번호
//
//        bus1.setPresentPeople(2);
//        bus1.rideleftprice();//탑승 승객 수, 잔여 승객 수, 요금 확인
//        bus1.plusMinusOil(-50);
//        bus1.presentOil();//주유량
//        bus1.stateChange();
//        bus1.plusMinusOil(10);
//        bus1.stateBus();//차고지행, 주유량
//        bus1.stateChange();
//        bus1.setPresentPeople(45);//최대 승객 수 초과
//        bus1.setPresentPeople(5);
//        bus1.rideleftprice();//탑승 승객 수, 잔여 승객 수, 요금 확인
//        bus1.plusMinusOil(-55);
//        bus1.stateBus();

        Texi texi1 = new Texi();
        Texi texi2 = new Texi();

        texi1.setPresentPeople(2, "서울역", 2);
        texi1.rideleftprice();
        texi1.plusMinusOil(-80);
        texi1.pay();
        texi1.setPresentPeople(5,"",0);
        texi1.rideleftprice();
        texi1.setPresentPeople(3, "구로디지털단지역", 12);
        texi1.rideleftprice();
        texi1.plusMinusOil(-20);
        texi1.pay();
    }
}
