import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Node[] tree;
	static StringBuilder sb;

	static class Node {
		char val;
		Node left;
		Node right;

		public Node(char val) {
			super();
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	static void preorder(Node node) {
		if (node == null) {
			return;
		}

		sb.append(node.val);
		preorder(node.left);
		preorder(node.right);
	}

	static void inorder(Node node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		sb.append(node.val);
		inorder(node.right);
	}

	static void postorder(Node node) {
		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		sb.append(node.val);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		tree = new Node[26];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char node = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			if (tree[node - 'A'] == null) {
				tree[node - 'A'] = new Node(node);
			}

			if (left != '.') {
				tree[left - 'A'] = new Node(left);
				tree[node - 'A'].left = tree[left - 'A'];
			}

			if (right != '.') {
				tree[right - 'A'] = new Node(right);
				tree[node - 'A'].right = tree[right - 'A'];
			}
		}

		preorder(tree[0]);
		sb.append("\n");

		inorder(tree[0]);
		sb.append("\n");

		postorder(tree[0]);

		System.out.println(sb.toString());
	}
}
