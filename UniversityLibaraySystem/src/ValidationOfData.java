// Nourhan Mohamed Ahmed Ismail          7153
// Shereen Mostafa Hassan Mabrouk  6844
public class ValidationOfData {

	public int validEmail(String email) {
		int i, flag = 0, fdot = 0, indexOfAd = 0, ad = 0;
		// if the last digit or the first letter is @ or . then return invalid email

		if (email.charAt(email.length() - 1) == '@' || email.charAt(email.length() - 1) == '.' || email.charAt(0) == '@'
				|| email.charAt(0) == '.' || email.charAt(0) == ' ' || email.charAt(0) == '\n')
			return 0;
		// starting from the second letter check that there is at least 1 letter before
		// the @
		for (i = 1; i < email.length(); i++) {
			// checking that the email has no spaces
			if (email.charAt(i) != ' ') {
				// to check that there isn't 2 dots after each other like name..name@domain.com
				if (email.charAt(i) == '.' && (email.charAt(i + 1) == '.'))
					return 0;
				// checking that email has @
				if (email.charAt(i) == '@') {
					// ad to check that the email contains only one @
					ad++;
					// check that it there isn't @@ or @.
					if (email.charAt(i + 1) == '@' || email.charAt(i + 1) == '.' || email.charAt(i - 1) == '.'
							|| email.charAt(i - 1) == '@' || ad != 1)
						return 0;
					else {
						flag = 1;
						indexOfAd = i;
					}
				}
				// checking for the existence of the dot
				else if (email.charAt(i) == '.' && email.charAt(i - 1) != '.' && email.charAt(i + 1) != '.' && flag == 1
						&& i != indexOfAd + 1) {
					fdot = 1;
				}
			} else
				return 0;

		}
		if (flag == 1 && fdot == 1)
			return 1;
		else
			return 0;

	}

	public String validName(String name) {
		int i;

		for (i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (Character.isLetter(ch) || ch == ' ') {
				continue;
			}
			return "null";
		}
		return name;
	}

	public String validCity(String name) {
		if (name.matches("^[a-zA-Z]*$") && (!name.equals("")) && (name != null))
			return name.trim();
		return "null";
	}

	public String validPass(String password) {
		boolean oneDigit = false, lowerChar = false, upperChar = false, specialChar = false;
		if (password.contains(" "))
			return null + " Password Must not contains space ";
		// Must have at least one numeric character.
		// Must have at least one lowercase character.
		// Must have at least one uppercase character.
		// Must have at least one special symbol among @#$%
		// Password length should be between 8 and 20.
		if (password.length() < 8 || password.length() > 20)
			return "null" + " Password Must be between 8 and 20 ";
		for (int i = 0; i < password.length(); i++) {
			Character pass = password.charAt(i);
			if (Character.isUpperCase(pass))
				upperChar = true;
			else if (Character.isLowerCase(pass))
				lowerChar = true;
			else if (pass.equals('@') || pass.equals('#') || pass.equals('$') || pass.equals('%'))
				specialChar = true;
			else if (Character.isDigit(pass))
				oneDigit = true;
			else
				return "null"
						+ " Password Must contains at least 1 digit , 1 lower case letter , 1 upper case letter and special char @#&%";
		}

		if (oneDigit && lowerChar && upperChar && specialChar)
			return password;
		else if (!oneDigit)
			return "null"
					+ " Password Must contains at least 1 digit , 1 lower case letter , 1 upper case letter and a special char @#&% ";
		else if (!lowerChar)
			return "null"
					+ " Password Must contains at least  1 lower case letter , 1 upper case letter and a special char @#&%";
		else if (!upperChar)
			return "null" + " Password Must contains at least 1 upper case letter and a special char @#&%";
		else
			return "null" + " Password Must contains at least a special char @#&%";

	}

	public static Integer tryParse(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public String validContactNo(String contactNo) {
		if (tryParse(contactNo) == null)
			return "null" + " ContactNo must be numbers";
		else
			return contactNo;
	}

	public String checkValidity(String id, String name, String password, String em, String address, String city,
			String contactNo) {// String validName =validName(name);

		if ((validName(name)).equals("null"))
			return "Name is invalid NO numbers";
		if (validPass(password).contains("null")) {
			return validPass(password).replace("null", "");
			// String tokens[] = validPass(password).split(" ");
			// return tokens[1];
		}
		if (validEmail(em) == 0)
			return "Incorrect Email";
		if (validCity(city).contains("null")) {
			return "City is invalid NO numbers";
		}
		if (validContactNo(contactNo).contains("null"))
			return "ContactNo must be numbers";

		else {
			return "add";
		}
	}

	public boolean validDate(String today, String returnD) {
		String tokens[] = today.split("-");
		int day1 = Integer.parseInt(tokens[0]);
		int month1 = Integer.parseInt(tokens[1]);
		int year1 = Integer.parseInt(tokens[2]);

		String tokens2[] = returnD.split("-");
		int day = Integer.parseInt(tokens2[0]);
		int month = Integer.parseInt(tokens2[1]);
		int year = Integer.parseInt(tokens2[2]);

		if (day1 <= day && month1 <= month && year1 <= year)
			;
		else {
			return false;
		}

		return true;

	}
}