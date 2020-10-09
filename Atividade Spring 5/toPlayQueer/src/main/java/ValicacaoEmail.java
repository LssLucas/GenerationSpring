

	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class ValicacaoEmail {

	    private String[] wrongNames() {
	        return new String[] { "-iktuz", "_iktuz", ".iktuz", "--iktuz", "__iktuz",
	                "..iktuz", "iktuz-", "iktuz_", "iktuz.", "iktuz--", "iktuz__",
	                "iktuz..", "iktuz-iktuz-", "iktuz_iktuz_", "iktuz.iktuz.", "123iktuz",
	                "iktuz.-", "iktuz_-" };
	    }

	    private String[] rightNames() {
	        return new String[] { "iktuz", "iktuz.iktuz", "iktuz.iktuz.iktuz",
	                "iktuz-iktuz", "iktuz-iktuz-iktuz", "iktuz_iktuz", "iktuz_iktuz_iktuz",
	                "iktuz-123", "iktuz_123", "iktuz.123", "iktuz.iktuz-iktuz_iktuz",
	                "iktuz123" };
	    }

	    private String[] wrongDomains() {
	        return new String[] { "domain", "-domain", ".domain", "_domain",
	                "domain-", "domain.", "domain_" };
	    }

	    private String[] rightDomains() {
	        return new String[] { "domain.com", "domain.com.br", "do-main.com",
	                "do-main.com.br", "domain123.com", "domain123.com.br" };
	    }

	    private void show(String[] values, String mask) {
	        Pattern pattern = Pattern.compile(mask);
	        for (int i = 0; i < values.length; i++) {
	            Matcher matcher = pattern.matcher(values[i]);
	        }
	    }

	    private void show(String[] values, String[] values2, String mask) {
	        Pattern pattern = Pattern.compile(mask);
	        String email;
	        for (int i = 0; i < values.length; i++) {
	            for (int j = 0; j < values2.length; j++) {
	                email = values[i] + '@' + values2[j];
	                Matcher matcher = pattern.matcher(email);
	                
	                matcher = pattern.matcher(email.toUpperCase());
	            }
	        }
	    }

	    private void start() {
	        String nameMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)*";
	        // show(wrongNames(), nameMask);
	        // show(rightNames(), nameMask);

	        String domainMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)+";
	        // show(wrongDomains(), domainMask);
	        // show(rightDomains(), domainMask);

	        String at = "@";
	        String emailMask = nameMask + at + domainMask;
	        show(rightNames(), rightDomains(), emailMask);
	        show(rightNames(), wrongDomains(), emailMask);
	        show(wrongNames(), wrongDomains(), emailMask);
	    }
	    public static void main(String[] args) {
	        new ValicacaoEmail().start();
	    }
}
