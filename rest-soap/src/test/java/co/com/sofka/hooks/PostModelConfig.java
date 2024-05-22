package co.com.sofka.hooks;

import co.com.sofka.models.PostItem;
import co.com.sofka.models.PostModel;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class PostModelConfig {
    @DataTableType
    public PostModel mapToPostModel (Map<String, String> postsData){
        return new PostModel(
                Integer.parseInt(postsData.get("userId")),
                postsData.get("title"),
                postsData.get("body")
        );
    }
}
