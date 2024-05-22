package co.com.sofka.hooks;

import co.com.sofka.models.PostItem;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class PostResponseConfig {
    @DataTableType
    public PostItem mapToPost (Map<String, String> postsData){
        return new PostItem(
                Integer.parseInt(postsData.get("userId")),
                Integer.parseInt(postsData.get("id")),
                postsData.get("title")
        );
    }
}
