public class News {
    private int storyId = 1;

    private static class Story {
        private String author;
        private String title;
        private String text;
        private HashSet<String> tags;
        private int readTime;


        public Story(String author, String title, String text, HashSet<String> tags) {
            this.author = author;
            this.title = title;
            this.text= text;
            this.tags = tags;
            this.readTime = 0;
        }
    }

    /**
     * To store the news {key=storyId: value=Story}
     */
    private HashMap<Integer, Story> storyMap = new HashMap<Integer, UserDetails>();

    public void addStory(String author, String title, String text, HashSet<String> tags) {
        Story story = new Story(author, title, text, tags);
        storyMap.put(storyId, Story);
        storyId++;
    }

    public void markStoryAsRead(String storyID) {
        storyID = Integer.parseInt(storyID);
        Story story = storyMap.get(storyID);
        story.readTime += 1
    }

    public void displayTopTenNews() {

    }

    public void displayStoriesForAuthor(String author) {

    }

    public void displayStoriesWithTags(HashSet<String> listOfTags) {

    }
}
