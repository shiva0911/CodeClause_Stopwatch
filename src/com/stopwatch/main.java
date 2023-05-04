package com.stopwatch;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Stopwatch implements ActionListener
{
	
	JFrame frame = new JFrame();
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int elapsendTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minute_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);

	Timer timer = new Timer(1000, new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			elapsendTime = elapsendTime + 1000;
			hours = (elapsendTime / 3600000);
			minutes = (elapsendTime / 60000) % 60;
			seconds = (elapsendTime / 1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minute_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string + ":" + minute_string + ":" + seconds_string);

		}

	});

	Stopwatch() {

		timeLabel.setText(hours_string + ":" + minute_string + ":" + seconds_string);
		timeLabel.setBounds(100, 100, 400, 200);
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		timeLabel.setBackground(Color.black);

		startButton.setBounds(100, 300, 200, 100);
		startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		startButton.setFocusable(false);
		startButton.setBackground(Color.red);
		startButton.addActionListener(this);

		resetButton.setBounds(300, 300, 200, 100);
		resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		resetButton.setFocusable(false);
		resetButton.setBackground(Color.green);
		resetButton.addActionListener(this);

		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Stopwatch");
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			if (started == false) {
				started = true;
				startButton.setText("STOP");
				start();

			} else {
				started = false;
				startButton.setText("START");
				stop();
			}
		}

		if (e.getSource() == resetButton) {
			started = false;
			startButton.setText("START");
			reset();

		}

	}

	void start() {
		timer.start();

	}

	void stop() {
		timer.stop();
	}

	void reset() {
		timer.stop();
		elapsendTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		seconds_string = String.format("%02d", seconds);
		minute_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string + ":" + minute_string + ":" + seconds_string);

	}

}

public class main {

	public static void main(String[] args) {
		Stopwatch watch = new Stopwatch();

	}

}
