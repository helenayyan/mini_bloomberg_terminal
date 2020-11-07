import News.Story;

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
            this.text = text;
            this.tags = tags;
            this.readTime = 0;
        }
    }

    /**
     * To store the news {key=storyId: value=Story}
     */
    private HashMap<Integer, Story> storyMap = new HashMap<Integer, UserDetails>();

    /**
     * To store the story from author {key=author: value=Story}
     */
    private HashMap<String, HashSet<Story>> authorMap = new HashMap<String, HashSet<Story>>();

    /**
     * Was thinking we could use linked list for stories ordered by readTime
     */


    /**
     * To be completed
     */
    public void addStory(String author, String title, String text, HashSet<String> tags) {
        Story story = new Story(author, title, text, tags);
        storyMap.put(storyId, Story);
        storyId++;

        // add the new story to authorMap
        if (authorMap.containsKey(author)) {
            HashSet<Story> stories = authorMap.get(author);
            stories.add(story);
            authorMap.put(author, stories);
        } else {
            HashSet<Story> stories = new HashSet<Story>();
            stories.add(story);
            authorMap.put(author, stories);
        }

        // To be completed: deal with order?

    }

    public void markStoryAsRead(String storyID) {
        storyID = Integer.parseInt(storyID);
        Story story = storyMap.get(storyID);
        story.readTime += 1;
    }

    public void displayTopTenNews() {

    }

    /*
     ** To be completed use authorMap
     */
    public void displayStoriesForAuthor(String author) {

    }

    public void displayStoriesWithTags(HashSet<String> listOfTags) {

    }
}
