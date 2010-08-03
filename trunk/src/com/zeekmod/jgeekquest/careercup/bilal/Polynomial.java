package com.zeekmod.jgeekquest.careercup.bilal;

public class Polynomial {

	private Term[] terms;
	
	private int degree;

	public Polynomial(Term[] terms, int degree) {
		this.terms = terms;
		this.degree = degree;
	}

	public void print() {
		System.out.println(this.toString());
	}

	public String toString() {
		StringBuffer s = new StringBuffer("P(X) = ");
		boolean first = true;
		for (int i = this.degree; i >= 0; i--) {
			if (first == false) {
				s.append(" + ");
			}
			s.append(terms[i].getString(i));
			first = false;
		}
		return s.toString();
	}
	
	public static void main(String[] args) {
		Term t1 = new TrivialPolynomialTerm(1);
		Term t2 = new TrivialPolynomialTerm(2);
		Term t3 = new TrivialPolynomialTerm(3);
		Term[] terms = {t1, t2, t3};
		int degree = terms.length-1;
		Polynomial p = new Polynomial(terms, degree);
		p.print();
	}

	public interface Term {

		public String getString(int degree);

	}

	public static class TrivialPolynomialTerm implements Term {

		private int data;

		public TrivialPolynomialTerm(int data) {
			this.data = data;
		}

		public String getString(int degree) {
			StringBuilder sb = new StringBuilder();
			sb.append(this.data);
			sb.append("X");
			if ( degree > 0) {
				sb.append("^");
				sb.append(degree);
			}
			return sb.toString();
		}

	}

}
