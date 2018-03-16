package layout;


import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.passwordandroid.R;
import edu.cnm.deepdive.passwordandroid.model.Game;
import edu.cnm.deepdive.passwordandroid.service.GameService;
import edu.cnm.deepdive.passwordandroid.service.GuessService;
import java.io.IOException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetupFragment extends Fragment implements OnClickListener {

  public static final String BASE_URL = "@string/base_url";

  private Spinner length;
  private EditText characters;
  private CheckBox repetition;
  private Button create;
  private String characterString;
  private String lengthString = length.getSelectedItem().toString();
  private GameService gameService;
  private GuessService guessService;
  private Game game;
  private Snackbar snack;
  private String id;

  public SetupFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_setup, container, false);
    length = view.findViewById(R.id.length_spinner);
    characters = view.findViewById(R.id.character_field);
    repetition = view.findViewById(R.id.repeat_spinner);
    create = view.findViewById(R.id.create_button);
    create.setOnClickListener(this);
    return view;
  }

  @Override
  public void onClick(View v) {
    if (create.getId() == v.getId()) {
      Editor editor = getActivity().getSharedPreferences("user", MODE_PRIVATE).edit();
      editor.putString("game_id", game.getId().toString());
      editor.apply();
    }
  }

  private void setup() {
    Gson gson = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create();
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
    gameService = retrofit.create(GameService.class);
    guessService = retrofit.create(GuessService.class);
  }


  public class GameBuild extends AsyncTask<Game, Object, Game> {

    @Override
    protected Game doInBackground(Game... games) {
      try {
        setup();
        game = new Game();
        if (characterString.isEmpty()) {
          game = new Game();
          game = gameService.create(game).execute().body();
        } else if (characterString.length() < Integer.parseInt(lengthString) &&
            !repetition.isChecked()) {
          game = gameService.create(game).execute().body();
        } else {
          game = new Game();
          game.setCharacters(characterString);
          game.setLength(Integer.parseInt(lengthString));
          game.setRepetitionAllowed(repetition.isChecked());
          game = gameService.create(game).execute().body();
        }
      } catch (IOException e) {
        e.printStackTrace();

      }
      return game;
    }

    @Override
    protected void onPostExecute(Game game) {
      snack = Snackbar.make(getActivity().findViewById(R.id.content),
          "Unexpected error please try again", Snackbar.LENGTH_LONG);
      snack.show();
    }
  }

}
