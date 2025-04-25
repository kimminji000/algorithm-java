import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder sb;

	private static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			super();
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	private static void postOrder(Node num) {
		if (num == null) {
			return;
		}

		postOrder(num.left);
		postOrder(num.right);
		sb.append(num.value).append("\n");
	}

	private static void insert(Node parent, int num) {
		if (parent.value > num) {
			if (parent.left == null) {
				parent.left = new Node(num);
			} else {
				insert(parent.left, num);
			}
		} else {
			if (parent.right == null) {
				parent.right = new Node(num);
			} else {
				insert(parent.right, num);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		Node root = new Node(Integer.parseInt(br.readLine()));

		while (true) {
			String input = br.readLine();

			if (input == null || input.equals("")) {
				break;
			}

			insert(root, Integer.parseInt(input));
		}

		postOrder(root);

		System.out.println(sb.toString());
	}
}
