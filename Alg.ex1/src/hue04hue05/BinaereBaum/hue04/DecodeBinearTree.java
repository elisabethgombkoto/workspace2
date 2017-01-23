package hue04hue05.BinaereBaum.hue04;

public class DecodeBinearTree {
	/**
	 * @author Elisabeth Gombkötö
	 * @since 10.11.2016 geendert am 28.11.2016
	 * 
	 */
	private Node<Character> _root;
	

	public DecodeBinearTree() {
		_root = new Node<Character>(null);

		_root.set_leftChild(new Node<Character>(null));
		_root.set_rightChild(new Node<Character>('E'));

		_root.get_leftChild().set_leftChild(new Node<Character>('T'));
		_root.get_leftChild().set_rightChild(new Node<Character>(null));

		_root.get_leftChild().get_rightChild().set_leftChild(new Node<Character>(null));
		_root.get_leftChild().get_rightChild().set_rightChild(new Node<Character>('N'));

		_root.get_leftChild().get_rightChild().get_leftChild().set_leftChild(new Node<Character>('S'));
		_root.get_leftChild().get_rightChild().get_leftChild().set_rightChild(new Node<Character>('I'));
	}

	/*
	 * In dieser Methode wird der binäre String entschlüsselt und als Plaintext
	 * zurückgegeben. Die binären Zahlen dienen als Richtungsweiser. Es werden
	 * Blätter gesucht, da nur diese Buchstaben enthalten. Wenn ein Blatt
	 * gefunden wird, wird der Buchstabe ans Plaintext drangehängt und man fangt
	 * wieder an der Wurzel an zu traversieren.
	 */
	public String encode(String binString) {
		StringBuilder encoding = new StringBuilder();
		int i = 0;
		Node<Character> currentNode = _root;

		while (i < binString.length()) {
			if (currentNode.getData() == null) {
				if (binString.charAt(i) == '1') {
					currentNode = currentNode.get_leftChild();
				} else {
					currentNode = currentNode.get_rightChild();
				}
			}
			if (currentNode.getData() != null) {
				encoding.append(currentNode.getData());
				currentNode = _root;
			}
			i++;
		}
		System.out.println(encoding.toString());
		return encoding.toString();
	}

}
