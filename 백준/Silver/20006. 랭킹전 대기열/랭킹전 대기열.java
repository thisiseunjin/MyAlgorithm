import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int p, m;
    static StringBuilder sb = new StringBuilder();
    static int availableRoomCount = 0;
    static ArrayList<RoomInfo> rooms = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());   //전체 플레이어의 수
        m = Integer.parseInt(st.nextToken());   //방의 정원


        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            Person p = new Person(level, nickname);
            boolean isFind = false; //들어갈 수 있는 방을 찾았는지 확인

            //2. 가능한 방이 있는지 확인
            for (int j = 0; j < rooms.size(); j++) {
                RoomInfo room = rooms.get(j);

                //입장 가능한지 확인
                if (room.isStart) continue;  //시작한 방이면 그냥 지나친다
                if (Math.abs(room.baseLevel - p.level) > 10) continue;   //레벨 차이 너무 낳이 나도 못간다.

                isFind = true;
                room.userInfo.add(p);   //갈수 있는 방이 있다?
                if (room.userInfo.size() == m) room.isStart = true;
                break;
            }

            if (!isFind) {
                rooms.add(new RoomInfo(p));
                if (m == 1) {
                    RoomInfo r = rooms.get(rooms.size() - 1);
                    r.isStart = true;
                }
            }
        }


        for (RoomInfo r : rooms) {
            r.userInfo.sort(Comparator.comparing(Person::getNickname));
            if (r.isStart) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            for (int j = 0; j < r.userInfo.size(); j++) {
                Person p = r.userInfo.get(j);
                sb.append(p.toString()).append("\n");
            }
        }

        System.out.println(sb);

    }

    static class RoomInfo {
        int cnt;    //이용자 수
        int baseLevel;  //처음 들어온 이용자의 수
        boolean isStart = false;
        ArrayList<Person> userInfo = new ArrayList<>();

        public RoomInfo(Person person) {
            this.cnt = 1;
            this.baseLevel = person.level;
            userInfo.add(person);
        }

    }

    static class Person {
        String nickname;
        int level;

        public Person(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }

        @Override
        public String toString() {
            return level + " " + nickname;
        }


    }
}