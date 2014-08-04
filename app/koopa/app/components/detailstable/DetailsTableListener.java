package koopa.app.components.detailstable;

import koopa.core.data.Token;
import koopa.util.Tuple;

public interface DetailsTableListener {

	void userSelectedDetail(Tuple<Token, String> detail);

}
