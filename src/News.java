import News.Story;

import java.sql.Timestamp;

public class News {
    private int id = 1;

    private static class Story {
        private String author;  // author of the story
        private String title;  // title of the story
        private String text;  // text of the story
        private HashSet<String> tags;  // tags this story belongs to
        private String storyID;  // unique identifier for each story
        private Timestamp postTime;  // post time of the story


        public Story(String author, String title, String text, HashSet<String> tags, String storyID, Timestamp postTime) {
            this.storyID = storyID
            this.author = author;
            this.title = title;
            this.text = text;
            this.tags = tags;
            this.postTime = postTime;
        }
    }

    // To store the news {key -> storyID; value -> Story}
    private HashMap<String, Story> storyMap = new HashMap<String, UserDetails>();

    // To store the story from author {key -> author; value -> storyID}
    private HashMap<String, HashSet<String>> authorMap = new HashMap<String, HashSet<String>>();

    // To store the stories of a tag {key->tag: value ->storyID}
    private HashMap<String, HashSet<String>> tagMap = new HashMap<String, HashSet<String>>();

    // To store the stories of a tag {key->storyID: value ->readTime}
    private HashMap<String, Integer> readTimeMap = new HashMap<String, Interger>();

    /**
     * To be completed
     */
    public void addStory(String author, String title, String text, HashSet<String> tags) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String storyID = Integer.toString(id);

        // add to storyMap
        Story story = new Story(author, title, text, tags, storyID, timestamp);
        storyMap.put(storyID, Story);

        // add to authorMap
        if (authorMap.containsKey(author)) {
            HashSet<String> stories = authorMap.get(author);
            stories.add(storyID);
            authorMap.put(author, stories);
        } else {
            HashSet<String> stories = new HashSet<String>();
            stories.add(storyID);
            authorMap.put(author, stories);
        }

        // add to readTimeMap
        readTimeMap.put(storyID, 0);

        // add to tagMap
        for (String tag : tags) {
            if (tagMap.containsKey(tag)) {
                HashSet<String> stories = tagMap.get(tag);
                stories.add(storyID);
                tagMap.put(tag, stories);
            } else {
                HashSet<String> stories = new HashSet<String>();
                stories.add(storyID);
                tagMap.put(tag, stories);
            }
        }

        id++;
    }

    /**
     * Update the readTimeMap by 1
     *
     * @param storyID: identifier of the story
     */
    public void markStoryAsRead(String storyID) {
        readTimeMap.put(storyID, map.get(storyID) + 1);
    }

    /**
     * Prints Top 10 stories based on the number of times they were read
     */
    public void displayTopTenNews() {
        // sort the readTimeMap in descending order:     ASC -> true; DSC -> false
        List sortedReadTimeStories = sortByValue(readTimeMap, false);

        for (int i = 0; (i < 10 & i < sortedReadTimeStories.size()); i++) {
            String storyId = sortedReadTimeStories.get(i);
            displayStory(storyId);
        }
    }

    /**
     * Prints all stories for a given author
     *
     * @param author: the name of the author
     */
    public void displayStoriesForAuthor(String author) {
        HashSet<String> stories = authorMap.get(author);

        for (String storyId : stories) {
            displayStory(storyId);
        }

    }

    public void displayStoriesWithTags(HashSet<String> listOfTags) {
        HashMap<String,>
    }

    /**
     * Print the story's author, title, text in a nice format
     *
     * @param storyID: identifier of the story
     */
    private static void displayStory(String storyID) {
        Story story = storyMap.get(storyID);
        System.out.println("Title: " + story.title);
        System.out.println("Author: " + story.author);
        System.out.println("Content : \n" + story.text);
    }

    /**
     * Sort Map by Value in descending order and return the sorted ids as a list
     *
     * @param unsortMap: the unsorted hashmap
     * @param order:     ASC -> true; DSC -> false
     */
    private static List sortByValue(HashMap<String, Integer> unsortMap, final boolean order) {
        List<Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        Map<String, Integer> sortedMap = list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

        List orderedIDs = new ArrayList();
        sortedMap.forEach((key, value) -> orderedIDs.add(key));

        return orderedIDs;
    }

}
