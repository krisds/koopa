package koopa.app;

import java.awt.Component;

public interface ApplicationListener {

	void switchedView(Component view);

	void closedDetail(Component view);

	void updatedView(Component view);
}
