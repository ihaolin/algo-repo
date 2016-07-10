package me.hao0.algo.tree;

/**
 * 红黑树实现: 性质: 1.节点要么红，要么黑; 2.根是黑色; 3.所有叶子都是黑色;(叶子为null节点)
 * 4.每个红色节点的两个子节点都是黑色(从每个叶子到根的所有路径上不能有两个连续的红色节点)
 * 5.从任一节点到其每个叶子的所有简单路径都包含相同数目的黑色节点
 */
public class RedBlackTree<T extends Comparable<T>> {
	private Node<T> root; // tree root
	private int size; // tree elements' count
	private Node<T> NIL = new Node<T>(null, null, null, null, Color.BLACK); // 标志叶子节点

	/**
	 * 插入元素
	 */
	public boolean insert(T t) {
		// 插入新节点时，以红色着色
		Node<T> n = new Node<T>(t, null, NIL, NIL, Color.RED);
		Node<T> pointer = root;
		boolean inserted = false;
		// 遍历插入
		while (!inserted) {
			if (root == null) { // 空树
				root = n;
				inserted = true;
			} else if (n.value.compareTo(pointer.value) > 0) { // 向右子树找
				if (pointer.right == NIL) { // 插入右边
					n.parent = pointer;
					pointer.right = n;
					inserted = true;
				} else {
					pointer = pointer.right;
				}
			} else if (n.value.compareTo(pointer.value) < 0) { // 向左子树找
				if (pointer.left == NIL) { // 插入左边
					n.parent = pointer;
					pointer.left = n;
					inserted = true;
				} else {
					pointer = pointer.left;
				}
			} else { // 相等了
				return false;
			}
		}
		size++;
		insertFixup(n); // 调整树
		return inserted;
	}

	/**
	 * 调整树以满足红黑树性质
	 * 
	 * @param n
	 *            新添加的节点
	 */
	private void insertFixup(Node<T> n) {
		// 若是树根
		if (n.parent == null) {
			n.color = Color.BLACK;
			return;
		}

		// 父节点为黑色，无须调整
		if (n.parent.color == Color.BLACK) {
			return;
		}

		Node<T> u = uncle(n);
		Node<T> g = grandParent(n);
		// 1.父节点及叔节点都为红色
		if (u != null && u.color == Color.RED) {
			// 将parent和uncle颜色置BLACK
			n.parent.color = Color.BLACK;
			u.color = Color.BLACK;
			// 将grand parent置RED
			g.color = Color.RED;
			// 递归调整 grand parent, 这时可想像grand parent为新添加的红色节点
			insertFixup(g);
		} else { // 父节点P是红色而叔节点是黑色或缺少
			if (n == n.parent.right && n.parent == g.left) { // n为父节点右孩子,且父节点为祖父节点的左孩子
				// 以父左旋
				leftRotate(n.parent);
				n = n.left;
			} else if (n == n.parent.left && n.parent == g.right) { // n为父节点左孩子,且父节点为祖父节点右孩子
				// 以父右旋
				rightRotate(n.parent);
				n = n.right;
			}
			n.parent.color = Color.BLACK; // parent颜色置为黑色
			g.color = Color.RED;
			if (n == n.parent.left && n.parent == g.left) { // n节点为父节点的左孩子，且父节点为祖父节点的左孩子
				// 以祖父右旋
				rightRotate(g);
			} else { // n节点为父节点的右孩子，且父节点为祖父节点的右孩子
				// 以祖父左旋
				leftRotate(g);
			}
		}
	}

	/**
	 * 中序遍历
	 */
	public void leftRootRight() {
		printLRR(root);
	}

	/**
	 * 中序遍历打印元素
	 */
	private void printLRR(Node<T> node) {
		if (node != NIL) { // 不是叶子节点
			printLRR(node.left);
			System.out.println(node.value + "[" + node.color + "]");
			printLRR(node.right);
		}
	}

	/**
	 * 获取某元素
	 * 
	 * @param t
	 *            待查找元素
	 * @return 对应元素或null
	 */
	public T get(T t) {
		Node<T> n = getN(t);
		return n == null ? null : n.value;
	}

	/**
	 * 获取某节点
	 * 
	 * @param t
	 *            元素
	 * @return 元素对应节点
	 */
	private Node<T> getN(T t) {
		Node<T> pointer = root;
		while (pointer != NIL) {
			if (pointer.value.compareTo(t) < 0) { // 右边子树找
				pointer = pointer.right;
			} else if (pointer.value.compareTo(t) > 0) { // 左边子树找
				pointer = pointer.left;
			} else { // 找到该节点
				break;
			}
		}
		return pointer == NIL ? null : pointer;
	}

	/**
	 * 删除元素
	 * 类似二叉查找树的删除
	 * @param t 待删除节点
	 * @return 删除成功返回true, 反之返回false
	 */
	public boolean remove(T t) {
		boolean removed = false;
		Node<T> n = getN(t); // 获取要删除的节点
		Node<T> replace = null; // 用于替换节点n
		Node<T> child = null; // 后继节点next的孩子节点
		if (n != null) {
			if (n.left == NIL || n.right == NIL) { // 若有最多一个非空孩子
				replace = n;
			} else { // 若有2个非空孩子, 则找其后继节点
				replace = locateNextN(n);
			}
			// 获取替换节点replace的孩子, 有可能为NIL
			child = replace.left != NIL ? replace.left : replace.right;
			// 删除节点replace, 连接replace父节点-->child节点
			child.parent = replace.parent;
			if (replace.parent == null) { // 根节点
				root = child;
			} else if (replace == replace.parent.left) { // replace为其父节点左孩子
				replace.parent.left = child;
			} else { // replace为其父节点右孩子
				replace.parent.right = child;
			}

			// 替换n节点的值为replace节点
			if (replace != n) {
				n.value = replace.value;
			}
			// 若后继节点为黑色, 则需做调整, 因为删除红色replace节点对红黑树性质无影响
			if (replace.color == Color.BLACK) {
				removeFixup(child);
			}
			removed = true;
		}
		return removed;
	}

	/**
	 * 由于删除节点而做调整
	 * @param n 删除节点的后继节点的孩子
	 */
	private void removeFixup(Node<T> n) {
		while (n != root && n.color == Color.BLACK) {
			if (n == n.parent.left) { // n为其父节点的左孩子
				Node<T> rightBrother = rightBrother(n);
				if (rightBrother.color == Color.RED) { // 右兄弟颜色为红，通过左旋，将其转换为黑色，以适配下面的三种情况
					rightBrother.color = Color.BLACK;
					n.parent.color = Color.RED;
					leftRotate(n.parent); // 以父左旋
					rightBrother = n.parent.right; //新设置rightChild
				}
				// 右兄弟的两个孩子都为黑色
				if (rightBrother.left.color == Color.BLACK
						&& rightBrother.right.color == Color.BLACK) {
					rightBrother.color = Color.RED;
					n = n.parent;
				} else if (rightBrother.right.color == Color.BLACK) { // 右兄弟右孩子为黑色
					rightBrother.left.color = Color.BLACK;
					rightBrother.color = Color.RED;
					rightRotate(rightBrother);
					rightBrother = n.parent.right;
				} else { // 右兄弟右孩子为红色或其他情况，比如为空叶子节点NIL
					rightBrother.color = n.parent.color;
					n.parent.color = Color.BLACK;
					rightBrother.right.color = Color.BLACK;
					leftRotate(n.parent);
					n = root;
				}
			} else { // n为其父节点的右孩子
				Node<T> leftBrother = leftBrother(n);
				if (leftBrother.color == Color.RED) { // 左兄弟为红色
					leftBrother.color = Color.BLACK;
					n.parent.color = Color.RED;
					rightRotate(n.parent);
					leftBrother = n.parent.left;
				}
				if (leftBrother.left.color == Color.BLACK
						&& leftBrother.right.color == Color.BLACK) { // 左兄弟左孩子和右孩子都为黑色
					leftBrother.color = Color.RED;
					n = n.parent;
				} else if (leftBrother.left.color == Color.BLACK) { // 仅左兄弟左孩子为黑色
					leftBrother.color = Color.RED;
					leftBrother.right.color = Color.BLACK;
					leftRotate(leftBrother);
					leftBrother = n.parent.left;
				} else { // 左兄弟左孩子为红色
					leftBrother.color = n.parent.color;
					n.parent.color = Color.BLACK;
					leftBrother.left.color = Color.BLACK;
					rightRotate(n.parent);
					n = root;
				}
			}
		}
		n.color = Color.BLACK;
	}

	/**
	 * 获取节点的右兄弟
	 * 
	 * @param n
	 *            当前节点
	 * @return 节点的右兄弟
	 */
	private Node<T> rightBrother(Node<T> n) {
		return n == null ? null : (n.parent == null ? null : n.parent.right);
	}

	/**
	 * 获取节点的左兄弟
	 * 
	 * @param n
	 *            当前节点
	 * @return 节点的右兄弟
	 */
	private Node<T> leftBrother(Node<T> n) {
		return n == null ? null : (n.parent == null ? null : n.parent.left);
	}

	/**
	 * 获取元素前驱(中序遍历)
	 * 
	 * @param t
	 *            指定元素
	 * @return 元素前驱，没有返回null
	 */
	public T prev(T t) {
		// 先找到该元素
		Node<T> cur = getN(t);
		if (cur != null) {
			return locatePrev(cur);
		}
		return null;
	}

	/**
	 * 定位到前驱节点
	 * 
	 * @param cur
	 *            当前节点
	 * @return 前驱节点，没有返回null
	 */
	private T locatePrev(Node<T> cur) {
		Node<T> prev = locatePrevN(cur);
		return prev == null ? null : prev.value;
	}

	/**
	 * 定位到前驱节点
	 * 
	 * @param cur
	 *            当前节点
	 * @return 当前节点的前驱节点
	 */
	private Node<T> locatePrevN(Node<T> cur) {
		if (cur != null) {
			// 1.如果该节点左子树不会空，则其前驱为其左子树的最大元素
			if (cur.left != null)
				return maxN(cur.left);
			// 2.该节点左子树为空, 则其前驱为：其祖先节点(递归), 且该祖先节点的右孩子也是其祖先节点
			// 通俗的说，一直忘上找找到左拐后那个节点;
			Node<T> p = cur.parent;
			while (p != null && cur == p.left) {
				cur = p;
				p = p.parent;
			}
			return p == null ? null : p;
		}
		return null;
	}

	/**
	 * 获取元素后继(中序遍历)
	 * 
	 * @param t
	 *            指定元素
	 * @return 后继元素，没有返回null
	 */
	public T next(T t) {
		// 先找到该元素
		Node<T> cur = getN(t);
		if (cur != null) {
			return locateNext(cur);
		}
		return null;
	}

	/**
	 * 定位当前节点的后继元素
	 * 
	 * @param cur
	 *            当前节点
	 * @return 其后继元素
	 */
	private T locateNext(Node<T> cur) {
		Node<T> next = locateNextN(cur);
		return next == null ? null : next.value;
	}

	/**
	 * 定位到当前节点的后继节点
	 * @param cur 当前节点
	 * @return 当前节点的后继节点
	 */
	private Node<T> locateNextN(Node<T> cur) {
		if (cur == null)
			return null;
		// 1.若其右子树不为空，那么其后继节点就是其右子树的最小元素
		if (cur.right != NIL)
			return minN(cur.right);
		// 2.若为空，应该为其祖先节点(递归)，且该祖先节点的左孩子也是其祖先节点
		// 通俗的说，一直忘上找，找到右拐后那个节点;
		Node<T> p = cur.parent;
		while (p != null && cur == p.right) {
			cur = p;
			p = p.parent;
		}
		return p;
	}

	/**
	 * 返回最小元素
	 * @return 获取某节点为根的树的最小元素
	 */
	public T min(Node<T> n) {
		Node<T> min = minN(n);
		return min == NIL ? null : min.value;
	}

	/**
	 * 返回最小节点
	 * @param n 树根节点
	 * @return 最小节点
	 */
	private Node<T> minN(Node<T> n) {
		Node<T> min = n;
		while (min.left != NIL) {
			min = min.left;
		}
		return min == NIL ? null : min;
	}

	/**
	 * 获取某节点为根的树的最大元素
	 * @return 最大元素, 没有返回null
	 */
	public T max(Node<T> n) {
		Node<T> max = maxN(n);
		return max == NIL ? null : max.value;
	}

	/**
	 * 获取某节点为根的树的最大节点
	 * @return 最大节点, 没有返回null
	 */
	public Node<T> maxN(Node<T> n) {
		Node<T> max = n;
		while (max.right != NIL) {
			max = max.right;
		}
		return max == NIL ? null : max;
	}

	/**
	 * 左旋以n节点为根的子树： 1.将rightChild的左子树作为n的右子树 2.将rightChild作为根
	 * 3.将n节点作为rightChild的左孩子
	 */
	private void leftRotate(Node<T> n) {
		Node<T> rightChild = n.right;
		// 1.
		// 将rightChild的左子树接到n的右边
		n.right = rightChild.left;
		if (rightChild.left != NIL)
			rightChild.left.parent = n;

		// 2.
		rightChild.parent = n.parent;
		if (n.parent == null) { // 若n为树根
			root = rightChild;
		} else if (n.parent.left == n) { // 若n为父亲的左孩子
			n.parent.left = rightChild;
		} else { // 若n为父亲的右孩子
			n.parent.right = rightChild;
		}

		// 3.
		rightChild.left = n;
		n.parent = rightChild;
	}

	/**
	 * 右旋以n节点为根的子树： 
	 * 1.将leftChild的右子树作为n的左子树 
	 * 2.将leftChild作为根
	 * 3.将n节点作为leftChild的右孩子
	 */
	private void rightRotate(Node<T> n) {
		Node<T> leftChild = n.left;

		// 1.
		n.left = leftChild.right;
		if (leftChild.right != NIL)
			leftChild.right.parent = n;

		// 2.
		leftChild.parent = n.parent;
		if (n.parent == null) { // n为树根
			root = leftChild;
		} else if (n == n.parent.left) { // n为父节点点左孩子
			n.parent.left = leftChild;
		} else { // n为父节点右孩子
			n.parent.right = leftChild;
		}

		// 3.
		leftChild.right = n;
		n.parent = leftChild;
	}

	/**
	 * 获取叔叔节点
	 * 
	 * @param n
	 *            当前节点
	 * @return 其叔节点
	 */
	private Node<T> uncle(Node<T> n) {
		Node<T> gp = grandParent(n);
		if (gp == null)
			return null;
		if (n.parent == gp.left) { // 若其父节点在其祖父节点左边
			return gp.right;
		} else {
			return gp.left;
		}
	}

	/**
	 * 获取祖父节点
	 * 
	 * @param n
	 *            当前节点
	 * @return 其祖父节点
	 */
	private Node<T> grandParent(Node<T> n) {
		if (n.parent == null)
			return null; // 树根
		return n.parent.parent;
	}

	/**
	 * 节点类
	 */
	private static class Node<E> {
		E value;
		Node<E> parent;
		Node<E> left;
		Node<E> right;
		Color color;

		public Node(E value, Node<E> parent, Node<E> left, Node<E> right,
				Color color) {
			this.value = value;
			this.parent = parent;
			this.left = left;
			this.right = right;
			this.color = color;
		}
	}

	/**
	 * 节点颜色
	 */
	private static enum Color {
		RED, BLACK
	}
}
