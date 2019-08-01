package mud;

public class MessageEdit {
	public static String edit(String message) {
		String newMessage="";
		int number=message.length();
		if (number <= CommonContent.CHARS_PER_LINE)
			newMessage += message + "\n";
		else {
			int i;
			for (i = 0; i <= number
					- CommonContent.CHARS_PER_LINE; i = i
					+ CommonContent.CHARS_PER_LINE) {
				newMessage += message.substring(i, i
						+ CommonContent.CHARS_PER_LINE)
						+ "\n";
			}
			newMessage += message.substring(i, number)
					+ "\n";
		}
		return newMessage;
	}
}