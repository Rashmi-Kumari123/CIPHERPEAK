(function () {
  'use strict';

  const MIN = 1;
  const MAX = 100;
  const MAX_ATTEMPTS = 7;

  let numberToGuess;
  let attempts;
  let totalScore = 0;
  let gameOver = false;

  const form = document.getElementById('guess-form');
  const input = document.getElementById('guess-input');
  const messageEl = document.getElementById('message');
  const attemptsLeftEl = document.getElementById('attempts-left');
  const totalScoreEl = document.getElementById('total-score');
  const playAgainSection = document.getElementById('play-again-section');
  const playAgainBtn = document.getElementById('play-again-btn');

  function setMessage(text, className) {
    messageEl.textContent = text;
    messageEl.className = 'message' + (className ? ' ' + className : '');
  }

  function initRound() {
    numberToGuess = Math.floor(Math.random() * (MAX - MIN + 1)) + MIN;
    attempts = 0;
    gameOver = false;
    input.value = '';
    input.disabled = false;
    form.querySelector('#guess-btn').disabled = false;
    playAgainSection.hidden = true;
    attemptsLeftEl.textContent = MAX_ATTEMPTS;
    totalScoreEl.textContent = totalScore;
    setMessage('');
    input.focus();
  }

  function endRound(won, revealedNumber) {
    gameOver = true;
    input.disabled = true;
    form.querySelector('#guess-btn').disabled = true;
    playAgainSection.hidden = false;
    playAgainBtn.focus();
    if (!won && revealedNumber !== undefined) {
      setMessage('Out of attempts. The number was: ' + revealedNumber, 'error');
    }
  }

  function handleGuess(e) {
    e.preventDefault();
    if (gameOver) return;

    const raw = input.value.trim();
    const num = parseInt(raw, 10);
    if (raw === '' || isNaN(num) || num < MIN || num > MAX) {
      setMessage('Enter a number between ' + MIN + ' and ' + MAX + '.', 'error');
      input.focus();
      return;
    }

    attempts += 1;
    const left = MAX_ATTEMPTS - attempts;
    attemptsLeftEl.textContent = left;

    if (num === numberToGuess) {
      const points = MAX_ATTEMPTS - attempts + 1;
      totalScore += points;
      totalScoreEl.textContent = totalScore;
      setMessage(`Correct! You guessed the number in ${attempts} ${attempts === 1 ? 'attempt' : 'attempts'}. +${points} points earned!`, 'success');
      endRound(true);
      return;
    }

    if (num < numberToGuess) {
      setMessage('Too low. Try again.', 'low');
    } else {
      setMessage('Too high. Try again.', 'high');
    }

    if (left <= 0) {
      endRound(false, numberToGuess);
      return;
    }

    input.value = '';
    input.focus();
  }

  function playAgain() {
    initRound();
  }

  form.addEventListener('submit', handleGuess);
  playAgainBtn.addEventListener('click', playAgain);

  initRound();
})();
