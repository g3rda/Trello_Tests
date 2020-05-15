package TrelloAPI;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TrelloApi {
    @POST("/1/boards/")
    Call<Board> createBoard(@Body Board board, @Query("name") String name);

    @PUT("/1/boards/{id}/members/{idMember}")
    Call<Board> addMember(@Path("id") String id, @Path("idMember") String idMember, @Query("type") String type, @Query("key") String key, @Query("token") String token);

    @DELETE("/1/boards/{id}")
    Call<Board> deleteBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);

    @POST("/1/lists")
    Call<ListTrello> createList(@Query("idBoard") String boardId, @Query("name") String listName, @Query("key") String key, @Query("token") String token);

    @PUT("/1/lists/{id}/closed")
    Call<ListTrello> archiveList(@Path("id") String idList, @Query("value") String value, @Query("key") String key, @Query("token") String token);

    @POST("/1/cards")
    Call<Card> createCard(@Body Card card, @Query("key") String key, @Query("token") String token);

    @POST("/1/labels")
    Call<Label> createLabel(@Body Label label);

    @POST("/1/cards/{id}/idLabels")
    Call<List<String>> addLabel(@Path("id") String id, @Query("value") String value, @Query("key") String key, @Query("token") String token);

}
