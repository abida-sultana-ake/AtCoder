import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// 別にこのクラスいらなかった感
class Node {
	int nodeNo;
	List<Integer> friends;

	public Node(int nodeNo, List<Integer> friends) {
		super();
		this.nodeNo = nodeNo;
		this.friends = friends;
	}

}

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M  =sc.nextInt();

		Node[] userList = new Node[N+1];

		for(int i=0; i<M; i++) {

			int a = sc.nextInt();
			int b = sc.nextInt();

			if(userList[a] == null) {
				userList[a] = new Node(a, new ArrayList<>());
			}
			userList[a].friends.add(b);

			if(userList[b] == null) {
				userList[b] = new Node(b, new ArrayList<>());
			}
			userList[b].friends.add(a);
		}

		sc.close();

		for(int userNum=1; userNum<=N; userNum++) {

			// 友達がいないユーザは友達の友達も0人
			if(userList[userNum] == null) {
				System.out.println(0);
				continue;
			}

			Set<Integer> friendsAndItself = new HashSet<>();

			friendsAndItself.addAll(userList[userNum].friends);
			friendsAndItself.add(userNum);

			Set<Integer> friendsFriends = new HashSet<>();
			for(Integer friendsNum : userList[userNum].friends) {
				friendsFriends.addAll(userList[friendsNum].friends);
			}

			friendsFriends.removeAll(friendsAndItself);
			System.out.println(friendsFriends.size());

		}

	}

}