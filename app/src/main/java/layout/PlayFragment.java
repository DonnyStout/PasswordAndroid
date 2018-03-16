package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.passwordandroid.R;
import edu.cnm.deepdive.passwordandroid.model.Game;
import edu.cnm.deepdive.passwordandroid.model.Guess;
import edu.cnm.deepdive.passwordandroid.service.GameService;
import edu.cnm.deepdive.passwordandroid.service.GuessService;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {


//  private static final String PROPERTIES_PATH = "resources/game.properties";
//  private static final String RESOURCE_BUNDLE_PATH = "resources/strings";
//  private static final String SERVICE_URL_KEY = "baseUrl";
//  private static final String GAME_PROMPT_KEY = "gamePrompt";
//  private static final String GUESS_PROMPT_KEY = "guessPrompt";
//  private static final String GUESS_LENGTH_ERROR_KEY = "guessLengthError";
//  private static final String GUESS_RESULT_KEY = "guessResult";
//  private static final String POSITIVE_CONDITION_KEY = "positivePluralCondition";
//  private static final String NEGATIVE_CONDITION_KEY = "negativePluralCondition";
//  private static final String SURRENDER_PROMPT_KEY = "surrenderPrompt";
//  private static final String AFFIRMATIVE_CHARACTER_KEY = "affirmativeCharacter";
//  private static final String SURRENDER_RESULT_KEY = "surrenderResult";
//  private static final String SOLVED_RESULT_KEY = "solvedResult";
//
//  private Properties properties;
//  private ResourceBundle bundle;
//  private GameService gameService;
//  private GuessService guessService;
//  private Game game;
//
  public PlayFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_play, container, false);
  }
//
//
//
//
//
//
//  private void setup() throws IOException {
//    properties = new Properties();
//    properties.load(getClass().getClassLoader().getResourceAsStream(PROPERTIES_PATH));
//    bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_PATH);
//    Gson gson = new GsonBuilder()
//        .excludeFieldsWithoutExposeAnnotation()
//        .create();
//    Retrofit retrofit = new Retrofit.Builder()
//        .baseUrl(properties.getProperty(SERVICE_URL_KEY))
//        .addConverterFactory(GsonConverterFactory.create(gson))
//        .build();
//    gameService = retrofit.create(GameService.class);
//    guessService = retrofit.create(GuessService.class);
//  }
//
//  private void play() throws IOException {
//    game = new Game();
//    // TODO Set game fields here (e.g. from properties or command line).
//    game = gameService.create(game).execute().body();
//    boolean keepPlaying = true;
//    int guessCount = 1;
//    out.printf(bundle.getString(GAME_PROMPT_KEY),
//        game.getLength(), game.getCharacters(), game.isRepetitionAllowed()
//            ? bundle.getString(POSITIVE_CONDITION_KEY)
//            : bundle.getString(NEGATIVE_CONDITION_KEY));
//    while (keepPlaying) {
//      out.printf(bundle.getString(GUESS_PROMPT_KEY), guessCount);
//      String input = in.nextLine().trim();
//      while (input.length() != game.getLength() && !input.isEmpty()) {
//        out.printf(bundle.getString(GUESS_LENGTH_ERROR_KEY), game.getLength());
//        input = in.nextLine().trim();
//      }
//      if (input.isEmpty()) {
//        keepPlaying = !surrender();
//      } else if (guess(input)) {
//        keepPlaying = false;
//      } else {
//        guessCount++;
//      }
//    }
//  }
//
//  private boolean guess(String input) throws IOException {
//    Guess guess = new Guess();
//    guess.setGuess(input);
//    guess = guessService.create(game.getId(), guess).execute().body();
//    game = gameService.read(game.getId()).execute().body();
//    if (game.isSolved()) {
//      out.printf(bundle.getString(SOLVED_RESULT_KEY), guess.getGuess());
//      return true;
//    } else {
//      out.printf(bundle.getString(GUESS_RESULT_KEY), guess.getInPlace(), guess.getOutOfPlace());
//      return false;
//    }
//  }
//
//  private boolean surrender() throws IOException {
//    out.printf(bundle.getString(SURRENDER_PROMPT_KEY));
//    String input = in.nextLine().trim().toLowerCase();
//    if (!input.isEmpty()
//        && (input.charAt(0) == bundle.getString(AFFIRMATIVE_CHARACTER_KEY).charAt(0))) {
//      gameService.surrender(game.getId(), true).execute();
//      game = gameService.read(game.getId()).execute().body();
//      if (game.isSurrendered()) {
//        out.printf(bundle.getString(SURRENDER_RESULT_KEY), game.getCode());
//        return true;
//      }
//    }
//    return false;
//  }
//
//}

}
