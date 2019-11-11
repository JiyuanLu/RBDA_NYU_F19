import java.io.*;
import twitter4j.*;

public class GetRecentTweets {
    public static String consumerKey = "";
	public static String consumerSecret = "";
	public static String accessToken = "";
	public static String accessTokenSecret = "";
	public static String[] keywords = {};

	public static void main(String[] args) throws TwitterException, IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output.txt")));
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret).setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);
		TwitterStream twitterStream = new TwitterStreamFactory(builder.build()).getInstance()
				.addListener(new StatusListener() {
					@Override
					public void onStatus(Status s) {
                        writer.write(s.getCreatedAt() + " - @" + s.getUser().getScreenName() + " - " + s.getText());
                        writer.newLine();
					}
				});
		FilterQuery query = new FilterQuery();
		query.track(keywords);
		query.language(new String[] { "en" });
		twitterStream.filter(query);
	}
}