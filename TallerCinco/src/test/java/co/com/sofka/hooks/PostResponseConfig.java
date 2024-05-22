package co.com.sofka.hooks;

import garcia.juan.models.PostItem;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class PostResponseConfig {
    @DataTableType
    public PostItem mapToPost (Map<String, String> postsData){
        return new PostItem(
                postsData.get("title"),
                postsData.get("body")
        );
    }
}