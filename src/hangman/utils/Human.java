package hangman.utils;
public class Human {
	public int gallow, ropeLength, head, body, neck, arm,
			leg, eye, scale;

	public Human() {
		gallow = 200;
		ropeLength = 40;
		head = 50;
		body = 60;
		neck = 10;
		arm = 25;
		leg = 30;
		eye = 10;
		scale = 1;
	}

	public void Scale(int _scale) {
		scale = _scale;
		gallow *= _scale;
		ropeLength *= _scale;
		head *= _scale;
		body *= _scale;
		neck *= _scale;
		arm *= _scale;
		leg *= _scale;
		eye *= _scale;
	}
}
